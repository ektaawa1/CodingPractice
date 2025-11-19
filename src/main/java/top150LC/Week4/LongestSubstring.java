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
        int l = 0;//left boundary
        HashSet<Character> set = new HashSet<>();
        for(int r = 0; r< s.length(); r++){ //right boundary r
            while(set.contains(s.charAt(r))){//but if we find a duplicate, we shrink from the left side, l
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));//move the right pointer r forward each time
            maxLen = Math.max(maxLen, r-l+1);//if l=2, r=4 then window size = 4-2+1=3 i.e. 2,3,4 total 3 elements
        }
        return maxLen;
    }
}
// s= "bbbbb", i = 0, set = []
//1)    j = 0, set = ['b']  , maxLen = (0,1)= 1
//2)    j = 1, set = [ ], i = 1, set = ['b'], maxLen = (1, 1) = 1
//3)    j = 2, set = [ ], i = 2, set = ['b'], maxLen = (1, 1) = 1
//4)    j = 3, set = [ ], i = 3, set = ['b'], maxLen = (1, (3-3+1)) = 1
//5)    j = 4, set = [ ], i = 4, set = ['b'], maxLen = (1, (4-4+1)) = 1
// output = 1

//TC = O(n)
//SC = O(n)
