import main.ast.nodes.CpyConverterToC;
import main.ast.nodes.OptimizationTypedefAndDefine;
import main.ast.nodes.Program;
import main.ast.nodes.ReachabilityAnalyzer;
import main.grammar.SimpleLangLexer;
import main.grammar.SimpleLangParser;
import main.symbolTable.SymbolTable;
import main.symbolTable.item.SymbolTableItem;
import main.visitor.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Vector;

public class SimpleLang {
    public static void main(String[] args) throws IOException {
        String convertedToCCode = CpyConverterToC.convert(args);
        String opt5 = OptimizationTypedefAndDefine.replaceTypedefsAndConstants(convertedToCCode);
//        System.out.println(opt5);
        CharStream reader = CharStreams.fromString(opt5); // remove define and typedef #5
        SimpleLangLexer simpleLangLexer = new SimpleLangLexer(reader);
        CommonTokenStream tokens = new CommonTokenStream(simpleLangLexer);
        SimpleLangParser flParser = new SimpleLangParser(tokens);
        Program program = flParser.program().programRet;

        NameAnalyzer nameAnalyzer = new NameAnalyzer();
        nameAnalyzer.visit(program);

        if (nameAnalyzer.chap()) {
//            System.out.println("oomad");
        }
        else {
            NameAnalyzerReturn nameAnalyzerReturn = new NameAnalyzerReturn(); // make null the things after "return" # 2 -> OK
            nameAnalyzerReturn.visit(program);

            NameAnalyzerUseLess nameAnalyzerUseLess = new NameAnalyzerUseLess(); // remove bikhodi ha # 3 -> OK
            nameAnalyzerUseLess.visit(program);


            while (true) {

                TestVisitor testVisitor = new TestVisitor();
                Opt1Visitor opt1Visitor = new Opt1Visitor();
                opt1Visitor.visit(program);
                Vector<SymbolTableItem> u = opt1Visitor.chap();
//                System.out.println("size: before remove: " + u.size());

                if (u.size() == 0) {
                    ReachabilityAnalyzer.analyze();
                    ReachabilityAnalyzer.cleanAST(program); // update AST based on reachable functions

                    testVisitor.visit(program);
                    break;
                }

//                System.out.println("-----------------------------------------------------------------");

                Opt1VisitorRemove opt1VisitorRemove = new Opt1VisitorRemove();
                opt1VisitorRemove.set(u);
                opt1VisitorRemove.visit(program);
                opt1VisitorRemove.chap();
//                System.out.println("size after remove: " + u.size());
            }
        }
        SymbolTable.root.hashCode();
    }
}