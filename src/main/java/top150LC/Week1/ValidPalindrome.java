package org.Week1;

//125. Valid Palindrome

// https://neetcode.io/solutions/valid-palindrome

/**
 *A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
 * and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * Example 1:
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.

 * Example 2:
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.

 * Example 3:
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric characters.
 * Since an empty string reads the same forward and backward, it is a palindrome.
 */

// 2 pointers approach
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length()-1;

        while(l < r) {
            //Move the left pointer forward until it points to a valid letter or digit.
            while(l < r && !alphaNum(s.charAt(l))){
                l++;
            }
            //Move the right pointer backward until it points to a valid letter or digit.
            while(r > l && !alphaNum(s.charAt(r))){
                r--;
            }
            //Compare the characters at l and r case-insensitively.
            //
            //If they don't match → it’s not a palindrome → return false.
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                return false;
            }
            //Move both pointers inward and repeat the check.
            l++;
            r--;
        }
        //If all characters matched until the pointers crossed, it is a valid palindrome.
        return true;
    }

    //Checks if the character is alphanumeric (a–z, A–Z, 0–9).
    private boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }
}
//TC = O(n)
//SC = O(1)