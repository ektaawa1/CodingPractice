package patternBased.slidingWIndow;
import java.util.HashMap;

//340. Longest Substring with At Most K Distinct Characters

/**
 * Given a string s and an integer k, return the length of the longest substring of s
 * that contains at most k distinct characters.
 */
public class LongestSubstringAtMostKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // return longest substring length
        // k distinct characters i.e., <= k
        // sliding window

        int left = 0;
        int maxLen = 0;
        HashMap<Character, Integer> map1 = new HashMap<>();

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            map1.put(ch, map1.getOrDefault(ch, 0)+1);

            while(map1.size() > k){
                //shrink the window
                char c1 = s.charAt(left);
                map1.put(c1, map1.get(c1)-1);
                if(map1.get(c1) == 0){
                    map1.remove(c1);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
}
// SC = O(n)
// TC = O(k)

/**
 * Examples-
 * Input: s = "aa", k = 1
 * Output: 2
 * Explanation: The substring is "aa" with length 2.
 *
 * Input: s = "eceba", k = 2
 * Output: 3
 * Explanation: The substring is "ece" with length 3.
 */