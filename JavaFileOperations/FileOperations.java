import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileOperations {

    private static final String FILE_NAME = "sample.txt";

    public static void main(String[] args) {
        try {
            // 1. Write to a file
            writeToFile("Hello, this is the original content.\nThis line will be modified.\n");

            // 2. Read from the file    
            System.out.println("Original File Content:");
            readFromFile();

            // 3. Modify content
            modifyFileContent("This line will be modified.", "Hello world!");

            // 4. Read modified content
            System.out.println("\nModified File Content:");
            readFromFile();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
        writer.write(content);
        writer.close();
    }

    public static void readFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    public static void modifyFileContent(String target, String replacement) throws IOException {
        Path path = Paths.get(FILE_NAME);
        List<String> lines = Files.readAllLines(path);
        List<String> modifiedLines = new ArrayList<>();

        for (String line : lines) {
            modifiedLines.add(line.replaceAll(target, replacement));
        }

        Files.write(path, modifiedLines);
    }
}
