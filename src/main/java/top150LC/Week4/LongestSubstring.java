package top150LC.Week4;
// Longest Substring Without Repeating Characters

import java.util.HashSet;
import java.util.Set;

/**
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

// Sliding Window with Hashmap or Hashset
public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int left = 0;
        HashSet<Character> charSet = new HashSet<>();
        for(int right = 0; right <s.length(); right++){
            while(charSet.contains(s.charAt(right))){
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
    public int lengthOfLongestSubstring1(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, maxLen = 0;

        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLen;
    }
}
//TC = O(n)
//SC = O(n)
