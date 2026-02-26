package patternBased.slidingWindow;
//1100: Find K-Length Substrings With No Repeated Characters

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Given a string s and an integer k, return the number of substrings of length k with no repeated characters.
 * Input:  s = "havefunonleetcode", k = 5
 * Output: 6
 * Input:  s = "home", k = 5
 * Output: 0
 * Input:  s = "aaaaa", k = 2
 * Output: 0
 */
public class SubstringSizeK {
    //prefer this
    //Time → O(n)
    //Space → O(k) (max size of set)
    public int countGoodSubstrings(String s, int k) {
        if (s.length() < k) return 0;

        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int count = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            // Remove duplicates inside window
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character
            set.add(ch);

            // Shrink window if size > k
            if (right - left + 1 > k) {
                set.remove(s.charAt(left));
                left++;
            }

            // Check valid window
            if (right - left + 1 == k) {
                count++;
            }
        }

        return count;
    }

    public int countGoodSubstrings1(String s, int k) {
        if (s.length() < k) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int count = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            // Add current character
            char currCh = s.charAt(right);
            map.put(currCh, map.getOrDefault(currCh, 0) + 1);

            // Remove character going out of window, i.e., shrink the window
            // Maintain window size k
            if (right - left + 1 > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            if (right - left + 1 == k && map.size() == k) {
                count++;
            }
        }
        return count;
    }
}
/**
 * Time: O(n)
 * Space: O(1) actually (since only lowercase letters → max 26)
 * Your estimate O(n) space is safe for intervie
 */
