import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileInspector {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser("src");
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            System.out.println("File chosen: " + selectedFile.getName());

            try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
                String line;
                int lineCount = 0;
                int wordCount = 0;
                int charCount = 0;

                while ((line = reader.readLine()) != null) {
                    lineCount++;
                    wordCount += line.split("\\s+").length;
                    charCount += line.length();
                    System.out.println(line);
                }

                System.out.println("\nSummary Report:");
                System.out.println("File: " + selectedFile.getName());
                System.out.println("Number of lines: " + lineCount);
                System.out.println("Number of words: " + wordCount);
                System.out.println("Number of characters: " + charCount);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}