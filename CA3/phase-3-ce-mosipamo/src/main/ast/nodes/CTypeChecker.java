package main.ast.nodes;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class CTypeChecker {

    private static final Map<String, Integer> TYPE_HIERARCHY = new HashMap<>();
    static {
        TYPE_HIERARCHY.put("char", 0);
        TYPE_HIERARCHY.put("short", 1);
        TYPE_HIERARCHY.put("int", 2);
        TYPE_HIERARCHY.put("long", 3);
        TYPE_HIERARCHY.put("float", 4);
        TYPE_HIERARCHY.put("double", 5);
    }

    private static final Pattern FUNCTION_DEF_PATTERN =
            Pattern.compile("\\b(void|int|float|double|char|short|long)\\s+([a-zA-Z_][a-zA-Z0-9_]*)\\s*\\(([^)]*)\\)\\s*\\{");

    private static final Pattern DECLARATION_WITH_INIT_PATTERN =
            Pattern.compile("\\b(int|float|double|char|short|long)\\s+([a-zA-Z_][a-zA-Z0-9_]*)\\s*(=\\s*([^;]+))?;");

    private static final Pattern EXPRESSION_PATTERN =
            Pattern.compile("\\b([a-zA-Z_][a-zA-Z0-9_]*)\\s*=\\s*([^;]+);");

    private static final Pattern RETURN_STATEMENT_PATTERN =
            Pattern.compile("\\breturn\\s*([^;]*);");


    private Map<String, String> currentSymbolTable = new HashMap<>();
    private String currentFunctionReturnType = null;

    private List<String> errors = new ArrayList<>();

    private String getLiteralType(String literalValue) {
        if (literalValue == null) {
            return null;
        }
        literalValue = literalValue.trim();

        if (literalValue.matches("^-?\\d*\\.\\d+(f|F)?$") || literalValue.matches("^-?\\d+\\.\\d*(f|F)?$")) {
            return "float";
        }
        if (literalValue.matches("^-?\\d*\\.\\d+(d|D)?$") || literalValue.matches("^-?\\d+\\.\\d*(d|D)?$")) {
            return "double";
        }
        if (literalValue.matches("^-?\\d+$")) {
            if (literalValue.toLowerCase().endsWith("l")) {
                return "long";
            }
            return "int";
        }
        if (literalValue.matches("^\".*\"$")) {
            return "string";
        }
        if (literalValue.matches("^'.?'$")) {
            return "char";
        }
        return null;
    }

    private String getPromotedType(String type1, String type2) {
        if (type1 == null || type2 == null) {
            return null;
        }
        if ("string".equals(type1) || "string".equals(type2)) {
            return "incompatible_operation";
        }

        Integer level1 = TYPE_HIERARCHY.get(type1);
        Integer level2 = TYPE_HIERARCHY.get(type2);

        if (level1 == null || level2 == null) {
            return null;
        }

        for (Map.Entry<String, Integer> entry : TYPE_HIERARCHY.entrySet()) {
            if (entry.getValue().equals(Math.max(level1, level2))) {
                return entry.getKey();
            }
        }
        return null;
    }

    private String resolveOperandType(String operandStr) {
        String type = currentSymbolTable.get(operandStr);
        if (type == null) {
            type = getLiteralType(operandStr);
        }
        return type;
    }

    private String analyzeAndGetExpressionType(String expressionStr, int lineNumber) {
        if (expressionStr == null || expressionStr.trim().isEmpty()) {
            return "void_return";
        }

        String singleOperandType = resolveOperandType(expressionStr);
        if (singleOperandType != null) {
            if ("string".equals(singleOperandType)) {
                return "string";
            }

            return singleOperandType;
        }

        String[] parts = expressionStr.split("(\\+|-|\\*|/)");
        List<String> cleanedParts = new ArrayList<>();
        for (String part : parts) {
            part = part.trim();
            if (!part.isEmpty()) {
                cleanedParts.add(part);
            }
        }

        String operator = null;
        for (char c : expressionStr.toCharArray()) {
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                operator = String.valueOf(c);
                break;
            }
        }

        if (cleanedParts.size() == 2 && operator != null) {
            String operand1Str = cleanedParts.get(0);
            String operand2Str = cleanedParts.get(1);

            String type1 = resolveOperandType(operand1Str);
            String type2 = resolveOperandType(operand2Str);

            String expressionResultType = getPromotedType(type1, type2);

            if ("incompatible_operation".equals(expressionResultType)) {
                errors.add("Line:" + lineNumber + " -> type mismatch in expression");
                return "ERROR";
            }
            return expressionResultType;

        } else {
            return null;
        }
    }


    public List<String> analyzeCodeForTypeErrors(String code) {
        currentSymbolTable.clear();
        errors.clear();
        currentFunctionReturnType = null;

        String[] lines = code.split("\n");

        for (int i = 0; i < lines.length; i++) {
            int lineNumber = i + 1;
            String line = lines[i].trim();

            if (line.isEmpty() || line.startsWith("//")) {
                continue;
            }

            Matcher funcDefMatcher = FUNCTION_DEF_PATTERN.matcher(line);
            if (funcDefMatcher.find()) {
                currentSymbolTable.clear();
                currentFunctionReturnType = funcDefMatcher.group(1);

                String paramString = funcDefMatcher.group(3);
                String[] params = paramString.split(",");
                for (String param : params) {
                    param = param.trim();
                    if (!param.isEmpty()) {
                        String[] parts = param.split("\\s+");
                        if (parts.length == 2) {
                            String paramType = parts[0];
                            String paramName = parts[1];
                            currentSymbolTable.put(paramName, paramType);
                        }
                    }
                }
                continue;
            }

            if (line.equals("}")) {
                currentSymbolTable.clear();
                currentFunctionReturnType = null;
                continue;
            }

            Matcher declMatcher = DECLARATION_WITH_INIT_PATTERN.matcher(line);
            if (declMatcher.find()) {
                String declaredType = declMatcher.group(1);
                String varName = declMatcher.group(2);
                String initializerExpression = declMatcher.group(4);

                currentSymbolTable.put(varName, declaredType);

                if (initializerExpression != null) {
                    String expressionResultType = analyzeAndGetExpressionType(initializerExpression, lineNumber);

                    if ("ERROR".equals(expressionResultType)) {
                        continue;
                    }
                    if (expressionResultType == null) {
                        continue;
                    }

                    boolean isFloatToIntegerNarrowing =
                            ("float".equals(expressionResultType) || "double".equals(expressionResultType)) &&
                                    ("char".equals(declaredType) || "short".equals(declaredType) || "int".equals(declaredType) || "long".equals(declaredType));

                    boolean isStringLiteralToNonChar =
                            "string".equals(expressionResultType) &&
                                    !("char".equals(declaredType) || "char*".equals(declaredType));

                    if (isFloatToIntegerNarrowing || isStringLiteralToNonChar) {
                        errors.add("Line:" + lineNumber + " -> type mismatch in expression");
                    }
                }
                continue;
            }

            // 3. Check for Re-assignment Expressions
            Matcher exprMatcher = EXPRESSION_PATTERN.matcher(line);
            if (exprMatcher.find()) {
                String assignVar = exprMatcher.group(1);
                String expressionStr = exprMatcher.group(2).trim();

                String assignedVarType = currentSymbolTable.get(assignVar);
                if (assignedVarType == null) {
                    continue;
                }

                String expressionResultType = analyzeAndGetExpressionType(expressionStr, lineNumber);

                if ("ERROR".equals(expressionResultType)) {
                    continue;
                }
                if (expressionResultType == null) {
                    continue;
                }

                boolean isFloatToIntegerNarrowing =
                        ("float".equals(expressionResultType) || "double".equals(expressionResultType)) &&
                                ("char".equals(assignedVarType) || "short".equals(assignedVarType) || "int".equals(assignedVarType) || "long".equals(assignedVarType));

                boolean isStringLiteralToNonChar =
                        "string".equals(expressionResultType) &&
                                !("char".equals(assignedVarType) || "char*".equals(assignedVarType));

                if (isFloatToIntegerNarrowing || isStringLiteralToNonChar) {
                    errors.add("Line:" + lineNumber + " -> type mismatch in expression");
                }
            }

            Matcher returnMatcher = RETURN_STATEMENT_PATTERN.matcher(line);
            if (returnMatcher.find() && currentFunctionReturnType != null) {
                String returnedExpressionStr = returnMatcher.group(1).trim();

                if ("void".equals(currentFunctionReturnType)) {

                } else {
                    String returnedType = analyzeAndGetExpressionType(returnedExpressionStr, lineNumber);

                    if ("ERROR".equals(returnedType)) {
                        continue;
                    }
                    if (returnedType == null) {
                        continue;
                    }

                    if ("void_return".equals(returnedType)) {
                        errors.add("Line:" + lineNumber + " -> return type mismatch");
                        continue;
                    }

                    Integer returnedLevel = TYPE_HIERARCHY.get(returnedType);
                    Integer expectedLevel = TYPE_HIERARCHY.get(currentFunctionReturnType);

                    boolean isReturnNarrowingOrIncompatible = false;

                    if (returnedLevel != null && expectedLevel != null) {
                        if (("float".equals(returnedType) || "double".equals(returnedType)) &&
                                ("char".equals(currentFunctionReturnType) || "short".equals(currentFunctionReturnType) || "int".equals(currentFunctionReturnType) || "long".equals(currentFunctionReturnType))) {
                            isReturnNarrowingOrIncompatible = true;
                        }

                        else if (returnedLevel > expectedLevel &&
                                !("float".equals(returnedType) || "double".equals(returnedType)) &&
                                ("char".equals(currentFunctionReturnType) || "short".equals(currentFunctionReturnType) || "int".equals(currentFunctionReturnType) || "long".equals(currentFunctionReturnType))) {
                            isReturnNarrowingOrIncompatible = true;
                        }

                        else if ("string".equals(returnedType) && !("char".equals(currentFunctionReturnType) || "char*".equals(currentFunctionReturnType))) {
                            isReturnNarrowingOrIncompatible = true;
                        }
                    }

                    if (isReturnNarrowingOrIncompatible) {
                        errors.add("Line:" + lineNumber + " -> return type mismatch");
                    }
                }
            }
        }

        if (!errors.isEmpty()) {
            for (String error : errors) {
                System.out.println(error);
            }
        }
        return errors;
    }
}
