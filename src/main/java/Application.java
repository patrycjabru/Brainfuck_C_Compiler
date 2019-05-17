import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import gen.brainfuckBaseVisitor;
import gen.brainfuckLexer;
import gen.brainfuckParser;
import gen.brainfuckVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Application {
    public static void main(String[] args) throws IOException {
        // Get our lexer
        String testString = "+[-[<<[+[--->]-[<<<]]]>>>-]>-.---.>..>.<<<<-.<+.>>>>>.>.<<.<-.";
        CharStream testStream = new ANTLRInputStream(testString);
        brainfuckLexer lexer = new brainfuckLexer(testStream);

        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Pass the tokens to the parser
        brainfuckParser parser = new brainfuckParser(tokens);

        String sourceFile = "result.c";

        FileWriter writer = new FileWriter(sourceFile);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);


        ParseTree parseTree = parser.file();
        // Add listener
//        brainfuckVisitor visitor = new brainfuckBaseVisitor();
//        visitor.visit(parseTree);

        BrainfuckListenerImpl listener = new BrainfuckListenerImpl(bufferedWriter);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener,parseTree);

        bufferedWriter.close();

        System.out.println();
        System.out.println(parseTree.toStringTree(parser)); // print LISP-style tree

    }
}
