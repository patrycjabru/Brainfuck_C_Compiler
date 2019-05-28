import java.io.*;

public class Application {
    public static void main(String[] args){
        System.out.println("Starting...");
        String testString;
        try {
            testString = FileManager.readFromFile(args[0]);
        } catch (FileNotFoundException e) {
            System.out.println("File with source code does not exist in current location: " + args[0]);
            return;
        }

        System.out.println("Source code has been read successfully: " + args[0]);

        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = FileManager.prepareOuputFile(args[1]);
        } catch (IOException e) {
            System.out.println("An error occurred while preparing the output file: " + args[1]);
            return;
        }

        System.out.println("Output file has been prepared successfully: " + args[1]);

        System.out.println("Beginning compilation...");

        Compiler.compile(testString, bufferedWriter);

        System.out.println("Compilation completed successfully");

        try {
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while closing the output file");
            e.printStackTrace();
        }
    }


}
