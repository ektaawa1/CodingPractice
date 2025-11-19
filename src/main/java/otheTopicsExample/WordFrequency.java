package otheTopicsExample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) throws IOException {
        // Map to store word counts
        Map<String, Integer> wordCount = new HashMap<>();
        // File path
        String fileName = "words.txt";

        // Read the file
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = br.readLine()) != null) {
            // Split line into words using whitespace
            String[] words = line.trim().split("\\s+");
            for (String word : words) {
                if (word.isEmpty()) continue; // skip empty strings
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
            }
        }
        br.close();

        // Sort words alphabetically
        List<String> wordsList = new ArrayList<>(wordCount.keySet());
        Collections.sort(wordsList);

        // Print word frequencies
        for (String word : wordsList) {
            System.out.println(word + " " + wordCount.get(word));
        }
    }
}
/**
 * Example:
 * Assume that words.txt has the following content:
 *
 * the day is sunny the the
 * the sunny is is
 * Your script should output the following, sorted by descending frequency:
 *
 * the 4
 * is 3
 * sunny 2
 * day 1
 */
