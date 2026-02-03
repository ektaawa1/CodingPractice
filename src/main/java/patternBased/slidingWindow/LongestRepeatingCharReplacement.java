package patternBased.slidingWindow;
// 424. Longest Repeating Character Replacement

/**
 * You are given a string s and an integer k.
 * You can choose any character of the string and change it to any other uppercase English character.
 * You can perform this operation at most k times.
 * Return the length of the longest substring containing the same letter you can get after performing the above operations.
 */
public class LongestRepeatingCharReplacement {
    public int characterReplacement(String s, int k) {
        //no need to change alphabets
        //Just make them part of window

        if(s.isEmpty() || s.length() <k){
            return 0;
        }

        int left = 0;
        char[] arr = s.toCharArray();
        int maxLen = Integer.MIN_VALUE;
        int maxFreq = Integer.MIN_VALUE;
        int[] freqArr = new int[26];

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            freqArr[ch - 'A']++;
            maxFreq = Math.max(maxFreq, freqArr[ch-'A']);

            int windowSize = right - left + 1;
            if(windowSize - maxFreq > k){
                //shrink the window
                freqArr[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}
//Similar to Max Consecutive Ones |||
/**
 * Note: We do not decrease maxFreq when shrinking the window, Why?
 * It does not affect correctness
 * It keeps the algorithm O(n)
 *
 * We allow maxFreq to be stale to keep O(n), correctness is preserved because we only care about maximum window length
 * If a sliding window variable is only used to decide when to shrink, it can be stale.
 * Because maxFreq is allowed to be slightly stale, and that never breaks correctness, but recomputing it would break O(n).
 * And would lead to O(n^2)
 * If we recalculated maxFreq every time
 * right moves n times
 * Inside: scan frequency map
 * ❌ Worst case becomes O(n²) in generic cases
 */

/**
 * window size = right - left + 1
 * replacements needed = window size - maxFreq
 *
 * if replacements > k:
 *     shrink window
 * else:
 *     update answer
 */

/**
 * Input: s = "ABAB", k = 2
 * Output: 4
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 *
 * Input: s = "AABABBA", k = 1
 * Output: 4
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * There may exists other ways to achieve this answer too.
 */
