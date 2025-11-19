package otheTopicsExample;

import java.util.*;

/**
 * Given an array of strings words and an integer k, return the k most frequent strings.
 * Return the answer sorted by the frequency from highest to lowest.
 * Sort the words with the same frequency by their lexicographical order.
 *
 * Example 1:
 * Input: words = ["i","love","leetcode","i","love","coding"], k = 2,  Output: ["i","love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 */
public class TopKFreqWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String s : words) {
            freqMap.put(s, freqMap.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> minHeap =
                new PriorityQueue<>((a, b) -> {
                    if (!a.getValue().equals(b.getValue())) {
                        return a.getValue() - b.getValue(); // smaller freq first
                    } else {
                        return b.getKey().compareTo(a.getKey()); // reverse lex order
                    }
                });

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll().getKey());
        }
        Collections.reverse(result);
        return result;
    }
}
//TC : O(n log k)

//Space Complexity: O(n)

/**
 * return b.getKey().compareTo(a.getKey()); in the heap comparator
 * Context: This is for the min-heap where we store (word, frequency) pairs.
 * Goal: We want the most frequent words to stay in the heap. But if two words have the same frequency,
 * the lexicographically smaller word should come first in the final output.
 */
/**
 * Collections.reverse(result);   Why? Because:
 *
 * The min-heap keeps the least frequent / lexicographically largest (for ties) on top.
 * When we poll the heap, the first word we get is the smallest in heap order, i.e., least frequent among top k.
 *
 * To get most frequent first in output, we reverse the list at the end.
 * Heap poll order (from min-heap): "banana", "apple"
 * After Collections.reverse(result) → "apple", "banana"
 */

/**
 * Lexicographical order is basically dictionary order — the way words are arranged in a dictionary.
 *
 * Compare letter by letter from left to right.
 *
 * The word that comes first alphabetically is “smaller.”
 *
 * Examples:
 *
 * "apple" < "banana" → because 'a' comes before 'b'
 *
 * "cat" < "catalog" → because the first letters are same, compare next letters; "cat" is shorter → comes first
 *
 * "bat" < "batman" → same rule
 *
 * ✅ Think: like how you’d find words in a dictionary.
 */
