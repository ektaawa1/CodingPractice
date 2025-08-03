package org.Week1;

import java.util.Arrays;

//242. Valid Anagram
//https://algo.monster/liteproblems/242
//https://neetcode.io/solutions/valid-anagram

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        //Using Hashtable
        // check if the length of both the inputs are same or not
        if(s.length() != t.length()){
            return false; //they can't be anagrams
        }

        int[] count = new int[26]; //Create an array to store the frequency of each lower case letter
        for(int i = 0; i<s.length(); i++ ){
            // Increment the count for each letter in string s
            count[s.charAt(i) - 'a']++;
            // Decrement the count for each letter in string t
            count[t.charAt(i) - 'a']--;
        }
        // Check if all counts are zero, indicating anagrams
        for(int val: count){
            if(val != 0){
                return false;
            }
        }
        return true;
    }

    /**
     * For i = 0:
     * s.charAt(i) → 'a'
     * 'a' - 'a' → 0
     * So count[0]++ → increases count of 'a' by 1
     *
     * For i = 1:
     * s.charAt(1) → 'p'
     * 'p' - 'a' → 15
     * count[15]++ → increases count of 'p' by 1
     * @param s
     * @param t
     * @return
     */
    public boolean is_anagram_using_sorting(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sSort = s.toCharArray();
        char[] tSort = t.toCharArray();
        Arrays.sort(sSort);
        Arrays.sort(tSort);
        return Arrays.equals(sSort, tSort);
    }
}

//TC = O(n+m)
//SC = O(1) since we have at most 26 different characters

//Explanation- the strings must have the same characters in the same quantities.

/**
 * If using Sorting
 *
 * TC= O(nlogn + mlogm)
 * SC = O(1) or O(n+m) depending on the sorting algo used
 * n & m are the length of the strings s & t
 */

//Note-
//O(n) is better than O(n log n) — because it's more efficient as input size grows.
