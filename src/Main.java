import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
        // Specify the file path here
        String filePath = "Textfile.txt";

        // Create a map to store word counts
        Map<String, Integer> wordCountMap = new TreeMap<>();

        // Read the file and count the words
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line into words using non-word characters as delimiters
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        word = word.toLowerCase(); // Convert word to lowercase
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }

        // Print the word counts in alphabetical order
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}