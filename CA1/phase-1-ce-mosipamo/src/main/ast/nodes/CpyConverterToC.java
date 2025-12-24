package main.ast.nodes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class CpyConverterToC {
    private final static int INDENT = 4;
    private final static String ENDSTR = "end";
    private final static String ELSESTR = "else";
    private final static Character EMPTYCHAR = ' ';
    private final static String LEFTPARWITHNEWLINE = "}\n";
    private final static String WRITEPARWITHNEWLINE = " {\n";
    private final static Character NEWLINECHAR = '\n';
    private final static Character SEMICOLONCHAR = ';';
    private final static String COLONSTR = ":";
    private final static String EMPTYSTR = "";
    private final static String NEWLINESTR = "\n";
    private final static String SHITSTR = ";{}";
    private final static String SPACESTR = " ";
    private final static String BACKSLASHR = "\r";

    private CpyConverterToC() {}

    public static String convert(Path path) throws IOException {
        List<String> linesStr = Files.readAllLines(path);
        StringBuilder res = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);

        boolean lastWasBlock = false;

        for (String line : linesStr) {
            String raw = line.replace(BACKSLASHR, EMPTYSTR);

            if (raw.strip().isEmpty()) {
                res.append(NEWLINESTR);
                continue;
            }

            int spaces = countForwardSpaces(raw);
            String trimmed = raw.stripLeading();

            while (spaces < stack.peek()) {
                stack.pop();
                indent(res, stack.peek()).append(LEFTPARWITHNEWLINE);
            }

            if (trimmed.equals(ENDSTR)) {
                while (stack.peek() > 0) {
                    stack.pop();
                    indent(res, stack.peek()).append(LEFTPARWITHNEWLINE);
                }
                continue;
            }

            boolean isBlock = trimmed.endsWith(COLONSTR);

            if (isBlock) {
                String header = trimmed.substring(0, trimmed.length() - 1);
                if (header.startsWith(ELSESTR) && lastWasBlock) {
                    res.setLength(res.length() - 2);
                    res.append(EMPTYCHAR).append(header).append(WRITEPARWITHNEWLINE);
                }
                else
                    indent(res, spaces).append(header).append(WRITEPARWITHNEWLINE);

                stack.push(spaces + INDENT);
                lastWasBlock = true;
            }
            else {
                indent(res, spaces).append(trimmed);
                if (!trimmed.isEmpty() && SHITSTR.indexOf(trimmed.charAt(trimmed.length() - 1)) == -1)
                    res.append(SEMICOLONCHAR);

                res.append(NEWLINECHAR);
                lastWasBlock = false;
            }
        }

        String cleaned = EmptyLineRemover.mamad(res.toString());
        return ElseJoiner.fixElseFormatting(cleaned);
    }

    public static int countForwardSpaces(String s) {
        int cnt = 0;
        while (cnt < s.length() && s.charAt(cnt) == EMPTYCHAR)
            cnt++;
        return cnt;
    }

    public static StringBuilder indent(StringBuilder stringBuilder, int numOfSpaces) {
        for (int i = 0; i < numOfSpaces; i++) {
            stringBuilder.append(' ');
        }
        return stringBuilder;
    }
}