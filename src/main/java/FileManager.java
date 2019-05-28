import java.io.*;
import java.util.Scanner;

public class FileManager {
    public static String readFromFile(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner sc = new Scanner(file);

        StringBuilder builder = new StringBuilder();
        while (sc.hasNextLine())
            builder.append(sc.nextLine());

        return builder.toString();
    }

    public static BufferedWriter prepareOuputFile(String path) throws IOException {
        FileWriter writer = new FileWriter(path);
        return new BufferedWriter(writer);
    }
}
