package patternBased.slidingWindow;
// 159. Longest Substring with At Most Two Distinct Characters

import java.util.HashMap;

/**
 * Given a string s, return the length of the longest substring that contains at most two distinct characters.
 *
 * Example-
 * Input: s = "eceba"
 * Output: 3
 * Explanation: The substring is "ece" which its length is 3.
 *
 * Input: s = "ccaabbb"
 * Output: 5
 * Explanation: The substring is "aabbb" which its length is 5.
 */
public class LongestSubstringAtMostTwoDistinct {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        // longest substring
        // distinct character <= 2
        // freqMap??
        int left = 0;
        int maxLen = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);

            while(freqMap.size() > 2){
                char leftCh = s.charAt(left);
                freqMap.put(leftCh, freqMap.get(leftCh)-1);
                if(freqMap.get(leftCh) == 0){
                    freqMap.remove(leftCh);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}
