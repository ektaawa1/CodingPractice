package patternBased.slidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
//3. Longest Substring Without Repeating Characters
/**
 * Input: s = "bbbbb"
 * Output: 1
 * Input: s = "abcabcbb"
 * Output: 3
 * Input: s = "pwwkew"
 * Output: 3
 * Given a string s, find the length of the longest substring without duplicate characters.
 */
public class LongestSubstringWithoutRepeatingChars {
    //prefer this
    public int lengthOfLongestSubstring(String s) {
        //longest substring without repeating characters
        //Since each pointer moves from 0 to n, the total number of operations is n + n = 2n.
        //Each character in the string is visited at most twice:
        // Once by the right pointer (when it's added to the set).
        // Once by the left pointer (when it's removed from the set).
        if(s.isEmpty() || s.length() == 0){
            return 0;
        }
        HashSet<Character> set1 = new HashSet<>();
        int left = 0;
        int maxLen = 0;
        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            while(set1.contains(ch)){
                set1.remove(s.charAt(left));
                left++;
            }
            set1.add(ch);
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
    //When you explain this, say: While the HashSet approach is O(n), it requires multiple operations per character
    // due to the sliding window shrinkage. The HashMap approach optimizes this to a single pass by
    // using the map to cache the index, allowing the left pointer to jump forward in constant time.
    public int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> map = new HashMap<>();//It stores character → last index where it appeared
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.containsKey(c)) {//The map is NOT representing the current window. It represents the entire history of last occurrences.
                left = Math.max(left, map.get(c) + 1); //left pointer is being jumped
                //The Math.max is there specifically to handle the scenario where the character found
                // in the map is outside (to the left of) your current window.
                // It ensures that the left pointer only moves forward.
            }

            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
    //Using an array for ascii chars whose range is from 0 to 127
    public int lengthOfLongestSubstring2(String s) {
        // We use -1 to represent that we haven't seen the character yet
        int[] lastSeen = new int[128];
        Arrays.fill(lastSeen, -1);

        int left = 0;
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // If we've seen this character and it's within our current window
            // When you perform the operation lastSeen[ch], Java is actually doing lastSeen[97] for an 'a'.
            if (lastSeen[ch] >= left) {
                left = lastSeen[ch] + 1;//make left pointer jump
            }

            lastSeen[ch] = right; // Store the index
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
//TC = O(2n) (hashset approach), O(n) for hashmap approach
//SC = O(n) or O(1) if using int[26] or int[128] instead of map or set
/**
 right → always moves forward

 left → moves only when invalid

 Window is [left, right]

 Track max length
 */
/**
 * HashSet method- You remove characters one by one:
 * ab → duplicate b → remove a → remove b → continue
 *
 * HashMap method- You jump left pointer directly:
 * left = lastIndex[b] + 1
 * ⚡ Faster in practice.
 */
/**
 * HashMap example- s = "abba"
 * Step by step:
 * right = 0 → 'a' map = {a:0}
 * left = 0
 *
 * right = 1 → 'b' map = {a:0, b:1}
 * left = 0
 *
 * right = 2 → 'b' (duplicate!) map.get('b') = 1
 * So:left = max(0, 1+1) = 2
 *
 * Now window becomes: "b"
 * We did NOT remove old 'b' from map.
 * Map still:
 * a → 0
 * b → 2
 * But that’s fine because: Left pointer already jumped. Window is valid.
 *
 * Note-
 * The HashMap approach is more efficient in practice because it reduces the number of operations by
 * jumping the left pointer directly. However, we should keep in mind the alphabet size.
 * If the character set is small (like ASCII), using an int[128] array instead of a HashMap
 * would be even more performant, as it avoids the overhead of hashing and object creation entirely.
 */

/**
 * Why left = Math.max(left, map.get(c) + 1);
 * 1. The Scenario (At index 4)
 * String: t m m z u x t
 * Indices: 0 1 2 3 4 5 6
 *
 * Current right pointer is at index 4 (character 'u').
 * Current left pointer is at index 2 (the second 'm').
 * Our map currently holds: {t:0, m:2, z:3}.
 * Now, we move the right pointer to index 6 (the second 't').
 *
 * If you use left = map.get(c) + 1 (The Buggy Version)
 * When right hits index 6 (char 't'):
 * The code looks up 't' in the map. It finds map.get('t') = 0.
 * It executes left = 0 + 1.
 * Result: Your left pointer jumps from 2 back to 1.
 * The Window: Your window is now [1, 6], which covers the substring "mmzuxt".
 * The Failure: Your window now contains two 'm's (at index 1 and index 2). The window is invalid because it violates the "no repeating characters" rule.
 */
