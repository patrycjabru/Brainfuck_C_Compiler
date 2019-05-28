import gen.brainfuckLexer;
import gen.brainfuckParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import java.io.*;

public class Compiler {
    public static void compile(String sourceCode, BufferedWriter writer) {
        System.out.println("Starting tokenization process...");

        CommonTokenStream tokens = tokenize(sourceCode);

        System.out.println("Tokenization completed successfully");
        System.out.println("Beginning parsing process...");

        brainfuckParser parser = new brainfuckParser(tokens);
        ParseTree parseTree = parser.file();

        System.out.println("Parsing completed successfully");

        System.out.println("Counting size of array...");
        int size = countArraySize(parseTree)*14+1;
        System.out.println("Size of array: " + size);
        
        System.out.println("Beginning code generation...");

        generateOutputCode(writer, parseTree, size);

        System.out.println("Code generation completed successfully");
    }

    private static CommonTokenStream tokenize(String soruceCode) {
        CharStream testStream = new ANTLRInputStream(soruceCode);
        brainfuckLexer lexer = new brainfuckLexer(testStream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return tokens;
    }

    private static void generateOutputCode(BufferedWriter writer, ParseTree parseTree, int size) {
        BrainfuckListenerImpl listener = new BrainfuckListenerImpl(writer, size);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener,parseTree);
    }
    
    private static int countArraySize(ParseTree parseTree) {
        ArraySizeCounterListenerImpl listener = new ArraySizeCounterListenerImpl();
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener,parseTree);
        return listener.getSize();
    }
}
