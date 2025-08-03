package org.Week4;
//                     ???????????????????????????? DO IT AGAIN ???????????????????????????????
//Approach
//Expand Around Center (Two Pointers) — O(n²), O(1) space
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int start = 0; int end = 0;
        if(s == null || s.length()<1){ //base case
            return "";
        }

        for(int i = 0; i<s.length(); i++){
            int len1 = expandFromCenter(s, i, i);//odd length;both the pointers will be at the single element
            int len2 = expandFromCenter(s,i,i+1);//even length; 2 pointers will be at two elements
            int maxLen = Math.max(len1,len2);

            if(maxLen > (end-start)){
                //update the end & start points
                //calculates the start and end index of the current palindrome.
                start = i-(maxLen-1)/2;
                end = i+maxLen/2;
            }
        }
        return s.substring(start,end+1);
    }
    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
        //We're expanding from the center outwards as long as characters match (i.e., a palindrome).
        //But when the while loop ends, left and right have moved one step too far—to non-matching characters.
        //So to get the correct length, we subtract one step from both ends.
    }
}

/**
 * Brute Force Approach
 * What About Your Sliding Window + Two Pointers Idea?
 * You can generate all substrings with varying window sizes and check if they're palindromes. But this leads to:
 * Time complexity: O(n³) — due to substring + palindrome check
 * That’s why we use expand from center to reduce it to O(n²)
 */
