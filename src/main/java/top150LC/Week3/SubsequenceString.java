package org.Week3;

public class SubsequenceString {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()){
            if(s.charAt(i) == t.charAt(j)){
                i++;
            }
            j++;
        }
        if(i == s.length()){
            return true;
        }
        return false; // or return i == s.length();
    }
}

/**
 * Explanation-
 * Use two pointers (i, j):
 * i moves over s (target string)
 * j moves over t (source string)
 * Whenever s[i] == t[j], increment i
 * Always increment j
 * If i == s.length() at the end, then s is a subsequence of t.
 */
// TC = O(n+m)
// SC = O(1)
