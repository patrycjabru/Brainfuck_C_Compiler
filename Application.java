import java.io.*;

import gen.brainfuckBaseVisitor;
import gen.brainfuckLexer;
import gen.brainfuckParser;
import gen.brainfuckVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Application{
    public static void main(String[] args) throws IOException {
        // Get our lexer


        //System.out.println("Odczyt pliku");
        BufferedReader fileReader = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        String filePath=br.readLine();
        String testString;
        try {
            fileReader = new BufferedReader(new FileReader(filePath));
            testString = fileReader.readLine();
            System.out.println(testString);
        } finally {
            if (fileReader != null) {
                fileReader.close();
            }
        }
        CharStream testStream = new ANTLRInputStream(testString);
        brainfuckLexer lexer = new brainfuckLexer(testStream);

        // Get a list of matched tokens
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Pass the tokens to the parser
        brainfuckParser parser = new brainfuckParser(tokens);


        int number=1;

        String resultPath=br.readLine();
        String nameFile = resultPath+"result.c";
          File sourceFile = new File(nameFile);

          while(sourceFile.exists())
          {
              nameFile = resultPath + "result" + (number++) + ".c";
              sourceFile = new File(nameFile);
          }

      FileWriter writer = new FileWriter(sourceFile);
      BufferedWriter bufferedWriter = new BufferedWriter(writer);


        ParseTree parseTree = parser.file();


        BrainfuckListenerImpl listener = new BrainfuckListenerImpl(bufferedWriter);
        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, parseTree);

        bufferedWriter.close();

        System.out.println();
        System.out.println(parseTree.toStringTree(parser)); // print LISP-style tree

    }
}
