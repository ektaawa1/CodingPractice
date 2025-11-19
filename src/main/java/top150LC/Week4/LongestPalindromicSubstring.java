package top150LC.Week4;

public class LongestPalindromicSubstring {
    //Optimal Solution-Expand Around Center (Two Pointers) — O(n²), O(1) space
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s; // single char is always a palindrome
        }

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Case 1: odd-length palindrome (center at i)
            int[] odd = expandFromCenter(s, i, i); // this returns the start & the end index of odd length palindrome

            // Case 2: even-length palindrome (center between i and i+1)
            int[] even = expandFromCenter(s, i, i + 1); // returns the start & end index of even length palindrome

            // Compare which one gives longer palindrome
            if (odd[1] - odd[0] > end - start) {
                start = odd[0];
                end = odd[1];
            }
            if (even[1] - even[0] > end - start) {
                start = even[0];
                end = even[1];
            }
        }

        return s.substring(start, end + 1);
    }

    private int[] expandFromCenter(String s, int start, int end) {
        // expand while characters match
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }

        // When loop breaks, left & right are one step beyond palindrome
        // So return the correct boundaries
        return new int[]{start + 1, end - 1};
        //WHY NOT return the substring directly?
        //
        //Because returning substring repeatedly is expensive
        //→ O(n) for each substring extraction → increased total time.
        //Returning indices is constant time and very lightweight.
    }

    public String longestPalindromeBruteForce(String s) {
        if (s == null || s.length() < 2) {
            return s; // single character is always a palindrome
        }

        int n = s.length();
        String longest = "";

        // Generate all substrings
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                String sub = s.substring(i, j + 1);

                if (isPalindrome(sub) && sub.length() > longest.length()) {
                    longest = sub;
                }
            }
        }

        return longest;
    }

    // Check if a string is a palindrome
    private boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

/**
 * Brute Force Approach
 * What About Your Sliding Window + Two Pointers Idea?
 * You can generate all substrings with varying window sizes and check if they're palindromes. But this leads to:
 * Time complexity: O(n³) — due to substring + palindrome check
 * That’s why we use expand from center to reduce it to O(n²)
 */
