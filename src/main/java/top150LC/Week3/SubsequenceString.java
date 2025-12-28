package top150LC.Week3;

/**
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by
 * deleting some (can be none) of the characters without disturbing the relative positions of
 * the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */
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

/**
 * Dry Run Example-
 * s = "abc", t = "ahbgdc"
 *
 * i=0 (a), j=0 (a) → match → i=1, j=1
 * i=1 (b), j=1 (h) → no match → j=2
 * i=1 (b), j=2 (b) → match → i=2, j=3
 * i=2 (c), j=3 (g) → no match → j=4
 * i=2 (c), j=4 (d) → no match → j=5
 * i=2 (c), j=5 (c) → match → i=3, j=6
 */