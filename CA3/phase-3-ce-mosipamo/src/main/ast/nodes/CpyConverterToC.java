package main.ast.nodes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

//public class CpyConverterToC {
//    private final static int INDENT = 4;
//    private final static String ENDSTR = "end";
//    private final static String ELSESTR = "else";
//    private final static Character EMPTYCHAR = ' ';
//    private final static String LEFTPARWITHNEWLINE = "}\n";
//    private final static String WRITEPARWITHNEWLINE = " {\n";
//    private final static Character NEWLINECHAR = '\n';
//    private final static Character SEMICOLONCHAR = ';';
//    private final static String COLONSTR = ":";
//    private final static String EMPTYSTR = "";
//    private final static String NEWLINESTR = "\n";
//    private final static String SHITSTR = ";{}";
//    private final static String SPACESTR = " ";
//    private final static String BACKSLASHR = "\r";
//
//    private CpyConverterToC() {}
//
//    public static String convert(Path path) throws IOException {
//        List<String> linesStr = Files.readAllLines(path);
//        StringBuilder res = new StringBuilder();
//        Deque<Integer> stack = new ArrayDeque<>();
//        stack.push(0);
//
//        boolean lastWasBlock = false;
//
//        for (String line : linesStr) {
//            String raw = line.replace(BACKSLASHR, EMPTYSTR);
//
//            if (raw.strip().isEmpty()) {
//                res.append(NEWLINESTR);
//                continue;
//            }
//
//            int spaces = countForwardSpaces(raw);
//            String trimmed = raw.stripLeading();
//
//            while (spaces < stack.peek()) {
//                stack.pop();
//                indent(res, stack.peek()).append(LEFTPARWITHNEWLINE);
//            }
//
//            if (trimmed.strip().equals(ENDSTR)) {
//                while (stack.peek() > 0) {
//                    stack.pop();
//                    indent(res, stack.peek()).append(LEFTPARWITHNEWLINE);
//                }
//                continue;
//            }
//
//            boolean isBlock = trimmed.endsWith(COLONSTR);
//
//            if (isBlock) {
//                String header = trimmed.substring(0, trimmed.length() - 1);
//                if (header.startsWith(ELSESTR) && lastWasBlock) {
//                    res.setLength(res.length() - 2);
//                    res.append(EMPTYCHAR).append(header).append(WRITEPARWITHNEWLINE);
//                }
//                else
//                    indent(res, spaces).append(header).append(WRITEPARWITHNEWLINE);
//
//                stack.push(spaces + INDENT);
//                lastWasBlock = true;
//            }
//            else {
//                indent(res, spaces).append(trimmed);
//                if (!trimmed.isEmpty() && SHITSTR.indexOf(trimmed.charAt(trimmed.length() - 1)) == -1)
//                    res.append(SEMICOLONCHAR);
//
//                res.append(NEWLINECHAR);
//                lastWasBlock = false;
//            }
//        }
//
//        String cleaned = EmptyLineRemover.mamad(res.toString());
//        return ElseJoiner.fixElseFormatting(cleaned);
//    }
//
//    public static int countForwardSpaces(String s) {
//        int cnt = 0;
//        while (cnt < s.length() && s.charAt(cnt) == EMPTYCHAR)
//            cnt++;
//        return cnt;
//    }
//
//    public static StringBuilder indent(StringBuilder stringBuilder, int numOfSpaces) {
//        for (int i = 0; i < numOfSpaces; i++) {
//            stringBuilder.append(' ');
//        }
//        return stringBuilder;
//    }
//}

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class CpyConverterToC {

    private static boolean inBlockComment = false;

    public static String convert(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(args[0]), StandardCharsets.UTF_8);
        Deque<Integer> indentStack = new ArrayDeque<>();
        indentStack.push(0);

        StringBuilder out = new StringBuilder();
        for (String raw : lines) {
            String code = stripComments(raw);

            if (code.strip().isEmpty()) {
                out.append("\n");
                continue;
            }

            List<String> cLines = convertCPYtoC(code, indentStack);
            for (String c : cLines) {
                out.append(c).append("\n");
            }
        }

        while (indentStack.size() > 1) {
            indentStack.pop();
            out.append("}\n");
        }

        return out.toString();
        // debug: show generated C
        // System.out.println("----- Generated C Source -----");
        // System.out.print(out);
        // System.out.println("----- End Generated C -----");

//        CharStream reader = CharStreams.fromString(out.toString());
//        SimpleLangLexer lexer    = new SimpleLangLexer(reader);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        SimpleLangParser parser  = new SimpleLangParser(tokens);
//        Program program          = parser.program().programRet;
//
//        new StatementCountVisitor().visit(program.getTranslationUnit());
    }

    private static String stripComments(String line) {
        StringBuilder sb = new StringBuilder();
        int i = 0, n = line.length();
        while (i < n) {

            if (!inBlockComment && i+1<n && line.charAt(i)=='/' && line.charAt(i+1)=='*') {
                inBlockComment = true;
                i += 2;
            }

            else if (inBlockComment && i+1<n && line.charAt(i)=='*' && line.charAt(i+1)=='/') {
                inBlockComment = false;
                i += 2;
            }

            else if (!inBlockComment && i+1<n && line.charAt(i)=='/' && line.charAt(i+1)=='/') {
                break;
            }

            else if (!inBlockComment) {
                sb.append(line.charAt(i++));
            }
            else {
                i++;
            }
        }
        return sb.toString();
    }

    private static List<String> convertCPYtoC(String raw, Deque<Integer> indentStack) {
        List<String> out = new ArrayList<>();
        String code = raw.strip();
        if (code.isEmpty()) {
            out.add("");
            return out;
        }

        int leading = raw.indexOf(code);
        int closeCount = 0;
        while (indentStack.size() > 1 && leading < indentStack.peek()) {
            indentStack.pop();
            closeCount++;
        }

        if (code.equals("end")) {
            if (indentStack.size() > 1) {
                indentStack.pop();
                closeCount++;
            }

            StringBuilder sbEnd = new StringBuilder();
            sbEnd.append("}".repeat(closeCount));
            out.add(sbEnd.toString());
            return out;
        }

        StringBuilder sb = new StringBuilder();
        if (closeCount > 0) {
            sb.append("}".repeat(closeCount));
        }

        if (code.endsWith(":")) {
            sb.append(code, 0, code.length()-1).append(" {");
            indentStack.push(leading + 4);
        }
        else if (code.endsWith(";") || code.endsWith("{") || code.endsWith("}")) {
            sb.append(code);
        }
        else {
            sb.append(code).append(";");
        }

        out.add(sb.toString());
        return out;
    }

}