package main.ast.nodes;

import java.util.*;
import java.util.regex.*;

public class TypeChecker {

    static class FunctionDef {
        String name;
        String returnType;
        List<String> paramTypes;
        int lineDefined;

        FunctionDef(String name, String returnType, List<String> paramTypes, int lineDefined) {
            this.name = name;
            this.returnType = returnType;
            this.paramTypes = paramTypes;
            this.lineDefined = lineDefined;
        }
    }

    static Map<String, String> variableTypes = new HashMap<>();
    static Map<String, FunctionDef> functionDefs = new HashMap<>();
    static String currentFunction = null;
    static String currentFunctionReturnType = null;

    public static void main(String args) {
        String inputCode = """
            void print1(int a, int b):
                int c = a + b
                printf(c)
            end

            void print2(float a, float b):
                int c = a + b
                printf(c)
            end

            int main():
                int a = 123
                float b = 5.5
                print1(a, b)
                print2(a, b)
                return 0
            end
        """;

        checkCode(args);
    }

    static void checkCode(String code) {
        String[] lines = code.split("\\n");
        Pattern funcDefPattern = Pattern.compile("(int|float|void)\\s+(\\w+)\\s*\\(([^)]*)\\)\\s*:");
        Pattern varDeclPattern = Pattern.compile("(int|float|String)\\s+(\\w+)\\s*=\\s*(.+)");
        Pattern funcCallPattern = Pattern.compile("(\\w+)\\s*\\(([^)]*)\\)");
        Pattern returnPattern = Pattern.compile("return\\s+(.+)");

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i].strip();

            // function definition
            Matcher funcDefMatch = funcDefPattern.matcher(line);
            if (funcDefMatch.find()) {
                String returnType = funcDefMatch.group(1);
                String name = funcDefMatch.group(2);
                String params = funcDefMatch.group(3).strip();
                List<String> paramTypes = new ArrayList<>();
                if (!params.isEmpty()) {
                    for (String p : params.split(",")) {
                        String[] tokens = p.strip().split("\\s+");
                        if (tokens.length == 2) {
                            String paramType = tokens[0];
                            String paramName = tokens[1];
                            paramTypes.add(paramType);
                            variableTypes.put(paramName, paramType); // register in current scope
                        }
                    }
                }
                functionDefs.put(name, new FunctionDef(name, returnType, paramTypes, i + 1));
                currentFunction = name;
                currentFunctionReturnType = returnType;
                continue;
            }

            // variable declaration with assignment
            Matcher varDeclMatch = varDeclPattern.matcher(line);
            if (varDeclMatch.find()) {
                String declaredType = varDeclMatch.group(1);
                String varName = varDeclMatch.group(2);
                String rhs = varDeclMatch.group(3).strip();
                String rhsType = getExpressionResultType(rhs);
                variableTypes.put(varName, declaredType);

                if (!typesCompatible(rhsType, declaredType)) {
                    System.out.println("Line:" + (i + 1) + " -> type mismatch in assignment");
                }
                continue;
            }

            // function call
            Matcher callMatch = funcCallPattern.matcher(line);
            if (callMatch.find()) {
                String name = callMatch.group(1);
                String[] args = callMatch.group(2).split(",");
                if (functionDefs.containsKey(name)) {
                    FunctionDef fd = functionDefs.get(name);
                    for (int j = 0; j < args.length; j++) {
                        if (j >= fd.paramTypes.size()) break;
                        String arg = args[j].strip();
                        String argType = getType(arg);
                        if (!typesCompatible(argType, fd.paramTypes.get(j))) {
                            System.out.println("Line:" + (i + 1) + " -> argument type mismatch");
                            break;
                        }
                    }
                }
                continue;
            }

            // return statement
            Matcher returnMatch = returnPattern.matcher(line);
            if (returnMatch.find()) {
                String returnValue = returnMatch.group(1).strip();
                String type = getType(returnValue);
                if (currentFunctionReturnType != null && !typesCompatible(type, currentFunctionReturnType)) {
                    System.out.println("Line:" + (i + 1) + " -> return type mismatch");
                }
                continue;
            }

            // function end
            if (line.equals("end")) {
                variableTypes.clear(); // reset scope
                currentFunction = null;
                currentFunctionReturnType = null;
                continue;
            }
        }
    }

    static String getExpressionResultType(String expr) {
        if (expr.matches("\".*\"")) return "String";
        if (expr.matches("\\d+\\.\\d+")) return "float";
        if (expr.matches("\\d+")) return "int";
        if (variableTypes.containsKey(expr)) return variableTypes.get(expr);

        // Handle binary expressions like a + b
        String[] ops = expr.split("[+\\-*/]");
        if (ops.length == 2) {
            String left = ops[0].strip();
            String right = ops[1].strip();
            String lType = getType(left);
            String rType = getType(right);

            if (lType.equals("String") || rType.equals("String")) return "String";
            if (lType.equals("float") || rType.equals("float")) return "float";
            if (lType.equals("int") && rType.equals("int")) return "int";
        }

        return "unknown";
    }

    static String getType(String val) {
        if (val.matches("\".*\"")) return "String";
        if (val.matches("\\d+\\.\\d+")) return "float";
        if (val.matches("\\d+")) return "int";
        if (variableTypes.containsKey(val)) return variableTypes.get(val);
        if (functionDefs.containsKey(val)) return functionDefs.get(val).returnType;
        return "unknown";
    }

    static boolean typesCompatible(String actual, String expected) {
        if (actual == null || expected == null) return false;
        if (actual.equals(expected)) return true;
        if (expected.equals("float") && actual.equals("int")) return true; // implicit cast allowed
        return false;
    }
}
