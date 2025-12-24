package main.ast.nodes;

public class EmptyLineRemover {

    private static final String EMPTYSTR = "";
    private static final String CLOSEDBRACES = "}";
    private static final String OPENDEDBRACES = "{";
    private static final String NEWLINE = "\n";

    public static String mamad(String code) {
        String[] linesStr = code.split(NEWLINE);
        StringBuilder res = new StringBuilder();
        boolean previousWasEmpty = false;
        boolean inFunction = false;
        int openBraces = 0;

        for (String line : linesStr) {
            String trimmed = line.strip();

            if (trimmed.endsWith(OPENDEDBRACES)) {
                inFunction = true;
                openBraces++;
            }
            else if (trimmed.equals(CLOSEDBRACES)) {
                openBraces--;
                if (openBraces <= 0)
                    inFunction = false;
            }

            if (trimmed.isEmpty()) {
                if (!inFunction && !previousWasEmpty) {
                        res.append(NEWLINE);
                        previousWasEmpty = true;
                }
                continue;
            }

            previousWasEmpty = false;
            res.append(line).append(NEWLINE);
        }

        return res.toString();
    }
}
