package grind75.Week1;

import java.util.HashMap;

public class LongestPalindromeLength {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        // int[] freq = new int[128]; // ASCII size
        for(char ch : s.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch,0) + 1);
        }
        int count = 0;
        boolean oddFound = false;

        for(int val : freq.values()){
            if(val %2 == 0){
                count += val;
            } else {
                count += val - 1;
                oddFound = true;
            }
        }

        if(oddFound){
            count += 1;
        }

        return count;
    }
    public int longestPalindrome1(String s) {
        int[] freq = new int[128]; // ASCII range

        // Count frequencies
        for (char c : s.toCharArray()) {
            freq[c]++;
        }

        int length = 0;
        boolean oddFound = false;

        // Traverse frequencies
        for (int count : freq) {
            if (count % 2 == 0) {
                length += count;         // use all if even
            } else {
                length += count - 1;     // use even part of odd
                oddFound = true;         // remember one odd
            }
        }

        // If any odd exists, put one odd character in the center
        if (oddFound) {
            length += 1;
        }

        return length;
    }
}

//TC = O(n)
//SC: Using HashMap → O(k), where k = number of distinct characters in the string.
// but since k ≤ 52 (bounded), we call it O(1) in Big-O.
//Using Array → O(1) (always fixed size).

/**
 * Dry Run Example
 * s = "abccccdd"
 *
 * Counts: {a=1, b=1, c=4, d=2}
 * Add evens: c=4 → 4, d=2 → 2 → length = 6
 * a=1 and b=1 → odds → we can put one in the center.
 *
 * Final length = 6 + 1 = 7, Answer = 7 (palindrome like "dccaccd").
 */
