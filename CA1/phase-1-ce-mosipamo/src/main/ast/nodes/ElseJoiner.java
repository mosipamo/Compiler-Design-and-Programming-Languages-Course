package main.ast.nodes;

public class ElseJoiner {
    public static String fixElseFormatting(String code) {
        String[] lines = code.split("\n");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < lines.length; i++) {
            String currentLine = lines[i].stripLeading();

            if ((currentLine.startsWith("else") || currentLine.startsWith("} else")) && i > 0) {
                int lastIndex = result.lastIndexOf("}");
                if (lastIndex != -1 && result.substring(lastIndex).trim().equals("}")) {
                    result.delete(lastIndex, result.length());
                    result.append("} ").append(currentLine).append("\n");
                    continue;
                }
            }
            result.append(lines[i]).append("\n");
        }
        return result.toString();
    }
}