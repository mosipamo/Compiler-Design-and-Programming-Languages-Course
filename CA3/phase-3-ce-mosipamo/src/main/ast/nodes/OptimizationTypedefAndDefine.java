package main.ast.nodes;

import java.util.*;
import java.util.regex.*;

public class OptimizationTypedefAndDefine {
    public static String replaceTypedefsAndConstants(String code) {
        Map<String, String> typedefMap = new HashMap<>();
        Map<String, String> defineMap = new HashMap<>();
        Map<String, String> constMap = new HashMap<>();
        List<String> outputLines = new ArrayList<>();

        String[] lines = code.split("\n", -1);

        for (String line : lines) {
            String t = line.trim();

            if (t.startsWith("typedef")) {
                Matcher m = Pattern.compile("typedef\\s+(\\w+)\\s+(\\w+)\\s*;").matcher(t);
                if (m.find()) typedefMap.put(m.group(2), m.group(1));

            } else if (t.startsWith("#define")) {
                Matcher m = Pattern.compile("#define\\s+(\\w+)\\s+(.+)").matcher(t);
                if (m.find()) {
                    String val = m.group(2).trim().replaceAll(";", "");
                    defineMap.put(m.group(1), val);
                }

            } else if (t.startsWith("const")) {
                Matcher m = Pattern.compile("const\\s+\\w+\\s+(\\w+)\\s*=\\s*(.+?);").matcher(t);
                if (m.find()) {
                    String varName = m.group(1).trim();
                    String value = m.group(2).trim();
                    constMap.put(varName, value);
                }
            }
        }

        for (String line : lines) {
            String trimmed = line.trim();

            if (trimmed.startsWith("typedef") || trimmed.startsWith("#define") || trimmed.startsWith("const")) {
                String indent = line.replaceAll("\\S.*", "");
                outputLines.add(indent);
            } else {
                outputLines.add(line);
            }
        }

        String result = String.join("\n", outputLines);

        for (var e : typedefMap.entrySet()) {
            result = result.replaceAll("\\b" + Pattern.quote(e.getKey()) + "\\b", e.getValue());
        }

        for (var e : defineMap.entrySet()) {
            result = result.replaceAll("\\b" + Pattern.quote(e.getKey()) + "\\b", e.getValue());
        }

        for (var e : constMap.entrySet()) {
            result = result.replaceAll("\\b" + Pattern.quote(e.getKey()) + "\\b", e.getValue());
        }

        return result;
    }
}
