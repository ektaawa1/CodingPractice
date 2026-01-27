package top150LC.Week4;

public class LongestPalindromicSubstring {
    //Optimal Solution-Expand Around Center (Two Pointers) — O(n²), O(1) space
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindrome
            String odd = expandFromCenter(s, i, i);
            if (odd.length() > longest.length()) longest = odd;

            // Even length palindrome
            String even = expandFromCenter(s, i, i + 1);
            if (even.length() > longest.length()) longest = even;
        }

        return longest;
    }
    private String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        //return right - left - 1;
        return s.substring(left + 1, right);
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
