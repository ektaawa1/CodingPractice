package org.Week1;
// ?????????????????                    DO AGAIN                              ??????????????
// 28. Find the Index of the First Occurrence in a String

/**
 * Example 1:
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 *
 * Example 2:
 * Input: haystack = "leetcode", needle = "leeto"
 * Output: -1
 * Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */
public class FirstOccurenceInString {
    public int strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();

        for(int i = 0; i < h-n+1; i++){
            if(haystack.substring(i,i+n).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
