package main.ast.nodes;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;

public class CheckNonSameOperands {

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

    // Removed PRINTF_CALL_PATTERN as we are no longer checking printf format strings.

    private Map<String, String> symbolTable = new HashMap<>();
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
        String type = symbolTable.get(operandStr);
        if (type == null) {
            type = getLiteralType(operandStr);
        }
        return type;
    }

    private String analyzeAndGetExpressionType(String expressionStr, int lineNumber) {
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

        String expressionResultType = null;

        if (cleanedParts.size() == 2 && operator != null) { // Binary operation
            String operand1Str = cleanedParts.get(0);
            String operand2Str = cleanedParts.get(1);

            String type1 = resolveOperandType(operand1Str);
            String type2 = resolveOperandType(operand2Str);

            expressionResultType = getPromotedType(type1, type2);

            if ("incompatible_operation".equals(expressionResultType)) {
                errors.add("Line:" + lineNumber + " -> type mismatch in expression");
                return "ERROR";
            }
            if (expressionResultType == null) {
                return null;
            }

        } else if (cleanedParts.size() == 1) { // Single literal or variable
            expressionResultType = resolveOperandType(cleanedParts.get(0));
            if ("string".equals(expressionResultType)) {
                return "string";
            }
        } else {
            return null;
        }
        return expressionResultType;
    }

    public List<String> analyzeCodeForTypeErrors(String code) {
        symbolTable.clear();
        errors.clear();

        String[] lines = code.split("\n");

        for (int i = 0; i < lines.length; i++) {
            int lineNumber = i + 1;
            String line = lines[i].trim();

            if (line.isEmpty() || line.startsWith("//")) {
                continue;
            }

            Matcher funcDefMatcher = FUNCTION_DEF_PATTERN.matcher(line);
            if (funcDefMatcher.find()) {
                symbolTable.clear();
                String paramString = funcDefMatcher.group(3);
                String[] params = paramString.split(",");
                for (String param : params) {
                    param = param.trim();
                    if (!param.isEmpty()) {
                        String[] parts = param.split("\\s+");
                        if (parts.length == 2) {
                            String paramType = parts[0];
                            String paramName = parts[1];
                            symbolTable.put(paramName, paramType);
                        }
                    }
                }
                continue;
            }

            if (line.equals("}")) {
                symbolTable.clear();
                continue;
            }

            Matcher declMatcher = DECLARATION_WITH_INIT_PATTERN.matcher(line);
            if (declMatcher.find()) {
                String declaredType = declMatcher.group(1);
                String varName = declMatcher.group(2);
                String initializerExpression = declMatcher.group(4);

                symbolTable.put(varName, declaredType);

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

            Matcher exprMatcher = EXPRESSION_PATTERN.matcher(line);
            if (exprMatcher.find()) {
                String assignVar = exprMatcher.group(1);
                String expressionStr = exprMatcher.group(2).trim();

                String assignedVarType = symbolTable.get(assignVar);
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

            // Removed the printf check block entirely.
        }

        if (!errors.isEmpty()) {
            for (String error : errors) {
                System.out.println(error);
            }
        }
        return errors;
    }

    public static void main(String args) {
        CheckNonSameOperands checker = new CheckNonSameOperands();
        checker.analyzeCodeForTypeErrors(args);

//        System.out.println("\n" + "=".repeat(50));
//        System.out.println("TEST CASE 1: float y = x + \"123\";");
//        System.out.println("=".repeat(50));
//        String code1 = """
//            int main() {
//                float x = 3.14f;
//                float y = x + "123";
//                return 0;
//            }
//            """;
//        checker.analyzeCodeForTypeErrors(code1);
//        // Expected: Type mismatch in expression 'x + "123"'. Cannot perform arithmetic with a string literal.
//
//        System.out.println("\n" + "=".repeat(50));
//        System.out.println("TEST CASE 2: int m = x + y; float n = x + y;");
//        System.out.println("=".repeat(50));
//        String code2 = """
//            int main() {
//                int x = 1;
//                float y = 1.1f;
//                int m = x + y;
//                float n = x + y;
//                return 0;
//            }
//            """;
//        checker.analyzeCodeForTypeErrors(code2);
//        // Expected: Type mismatch in expression 'x + y'. Resulting type 'float' is higher than assigned type 'int'.
//
//        System.out.println("\n" + "=".repeat(50));
//        System.out.println("TEST CASE 3: Valid Operations and Promotions");
//        System.out.println("=".repeat(50));
//        String code3 = """
//            int main() {
//                int a = 10;
//                long b = 20L;
//                float c = 3.5f;
//                double d = a + c; // int + float -> float, then float to double (safe)
//                long e = a + b;   // int + long -> long (safe)
//                int f = a + 5;
//                float g = c + 10; // float + int -> float (safe)
//                return 0;
//            }
//            """;
//        checker.analyzeCodeForTypeErrors(code3);
//        // Expected: No significant type errors
//
//        System.out.println("\n" + "=".repeat(50));
//        System.out.println("TEST CASE 4: String literal assignment to int");
//        System.out.println("=".repeat(50));
//        String code4 = """
//            int main() {
//                int my_int = 10;
//                int bad_int = "hello"; // Directly assigning string literal to int
//          args      return 0;
//            }
//            """;
//        checker.analyzeCodeForTypeErrors(code4);
//        // Expected: Cannot assign string literal to non-char type 'int'.
//
//        System.out.println("\n" + "=".repeat(50));
//        System.out.println("TEST CASE 5: Simple assignment with narrowing");
//        System.out.println("=".repeat(50));
//        String code5 = """
//            int main() {
//                float pi_val = 3.14f;
//                int approx_pi = pi_val;
//                return 0;
//            }
//            """;
//        checker.analyzeCodeForTypeErrors(code5);
        // Expected: Resulting type 'float' is higher than assigned type 'int'.
    }
}