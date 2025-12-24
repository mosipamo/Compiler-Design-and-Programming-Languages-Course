import main.ast.nodes.CpyConverterToC;
import main.ast.nodes.Program;
import main.grammar.SimpleLangLexer;
import main.grammar.SimpleLangParser;
import main.visitor.TestVisitor;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import java.io.IOException;
import java.nio.file.*;

public class SimpleLang {
    public static void main(String[] args) throws IOException {
        Path src = Paths.get(args[0]);
        String convertedToCCode = CpyConverterToC.convert(src);
        CharStream reader = CharStreams.fromString(convertedToCCode);
        SimpleLangLexer simpleLangLexer = new SimpleLangLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(simpleLangLexer);
        SimpleLangParser flParser = new SimpleLangParser(tokens);
        Program program = flParser.program().programRet;
        TestVisitor testVisitor = new TestVisitor();
        testVisitor.visit(program);
    }
}