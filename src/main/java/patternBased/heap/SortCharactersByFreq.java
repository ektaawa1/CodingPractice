package patternBased.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string s, sort it in decreasing order based on the frequency of the characters.
 * The frequency of a character is the number of times it appears in the string.
 * Return the sorted string. If there are multiple answers, return any of them.
 * Example 1:
 *
 * Input: s = "tree"
 * Output: "eert"
 * Explanation: 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 */
public class SortCharactersByFreq {
    public String frequencySort(String s) {
        HashMap<Character,Integer> freqMap = new HashMap<>();
        //Build Freq Map
        for(char c: s.toCharArray()){
            freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
        }

        //Use MaxHeap here
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        maxHeap.addAll(freqMap.keySet());

        StringBuilder sb = new StringBuilder();
        while(!maxHeap.isEmpty()){
            //Map.Entry<Character,Integer> entry = maxHeap.poll();
            char c = maxHeap.poll();
            int freq = freqMap.get(c);
            for (int i = 0; i < freq; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
//TC = O(n log k)
//SC = O(n + k)

/**
 * // 2. Put characters into a list and sort by frequency
 *     List<Character> characters = new ArrayList<>(freqMap.keySet());
 *     characters.sort((a, b) -> freqMap.get(b) - freqMap.get(a)); // Descending order
 */
