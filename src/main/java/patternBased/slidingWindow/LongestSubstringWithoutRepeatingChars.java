package patternBased.slidingWindow;

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
        //longest substring
        //without duplicates so use HashSet
        //variable size window
        //build the substring
        //if character is present in hashset then remove char from left and add it from right
        //if not present, add it in hashset

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
    public int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> map = new HashMap<>();//It stores character → last index where it appeared
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (map.containsKey(c)) {//The map is NOT representing the current window. It represents the entire history of last occurrences.
                left = Math.max(left, map.get(c) + 1); //left pointer is being jumped
            }

            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}
//TC = O(n)
//SC = O(n)
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
 *
 * right = 0 → 'a'
 *
 * map = {a:0}
 * left = 0
 *
 * right = 1 → 'b'
 *
 * map = {a:0, b:1}
 * left = 0
 *
 * right = 2 → 'b' (duplicate!)
 *
 * map.get('b') = 1
 *
 * So:
 *
 * left = max(0, 1+1) = 2
 *
 *
 * Now window becomes:
 *
 * "b"
 *
 *
 * We did NOT remove old 'b' from map.
 *
 * Map still:
 *
 * a → 0
 * b → 2
 *
 *
 * But that’s fine because:
 *
 * Left pointer already jumped.
 *
 * Window is valid.
 */
