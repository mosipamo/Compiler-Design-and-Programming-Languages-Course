import main.ast.nodes.CTypeChecker;
import main.ast.nodes.CheckNonSameOperands;
import main.ast.nodes.CpyConverterToC;
import main.ast.nodes.Program;
import main.grammar.SimpleLangLexer;
import main.grammar.SimpleLangParser;
import main.visitor.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import java.io.IOException;

public class SimpleLang {
    public static void main(String[] args) throws IOException {
        String convertedToCCode = CpyConverterToC.convert(args);
//        System.out.println(convertedToCCode);
        CharStream reader = CharStreams.fromString(convertedToCCode);
        SimpleLangLexer simpleLangLexer = new SimpleLangLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(simpleLangLexer);
        SimpleLangParser flParser = new SimpleLangParser(tokens);
        Program program = flParser.program().programRet;

        NameAnalyzer nameAnalyzer = new NameAnalyzer();
        nameAnalyzer.visit(program);


        if (nameAnalyzer.chap()) {
//            System.out.println("nameAnalysis is called");
//            System.out.println("-------------------------------------------------------------------------------------------");
        }
        else {
//            System.out.println("nameAnalysis is not called");
//            System.out.println("-------------------------------------------------------------------------------------------");
        }

//        System.out.println("memoryLeak is called:");
        MemoryLeakVisitor memoryLeakVisitor = new MemoryLeakVisitor();
        memoryLeakVisitor.visit(program);
//        System.out.println();

//        System.out.println("-------------------------------------------------------------------------------------------");

//        System.out.println("uninitializedVariable is called:");
        UninitializedVariableVisitor uninitializedVariableVisitor = new UninitializedVariableVisitor();
        uninitializedVariableVisitor.visit(program);
//        System.out.println();

//        System.out.println("-------------------------------------------------------------------------------------------");

//        System.out.println("usercontrollmalloc is called:");
        UserControlledMalloc userControlledMalloc = new UserControlledMalloc();
        userControlledMalloc.visit(program);
//        System.out.println();

//        System.out.println("-------------------------------------------------------------------------------------------");

//        System.out.println("ArgumentTypeMismatch is called:");
        ArgumentTypeMismatchAnalyzer argumentTypeMismatchAnalyzer = new ArgumentTypeMismatchAnalyzer();
        argumentTypeMismatchAnalyzer.visit(program);
        argumentTypeMismatchAnalyzer.chap();
//        System.out.println();

//        System.out.println("-------------------------------------------------------------------------------------------");
//        System.out.println("NonSameOperands is called:");

        // comment
//        CheckNonSameOperands cTypeChecker = new CheckNonSameOperands();
//        cTypeChecker.analyzeCodeForTypeErrors(convertedToCCode);
        CTypeChecker cTypeChecker = new CTypeChecker();
        cTypeChecker.analyzeCodeForTypeErrors(convertedToCCode);

//        NonSameOperandsVisitor nonSameOperandsVisitor = new NonSameOperandsVisitor();
//        nonSameOperandsVisitor.visit(program);
//        nonSameOperandsVisitor.chap();
//        TypeChecker.main(convertedToCCode);
    }
}