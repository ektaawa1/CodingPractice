package org.Week2;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        int s = 0;
        int n = x;

        if (x < 0) { // negative numbers are not palindrome
            return false;
        }
        while(n!=0){
            int a = n % 10;
            s = s*10+a;
            n = n/10;
        }
        if ( x != s){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean isPalindrome1(int x) {
        // Any negative number cannot be a palindrome
        // Additionally, if the last digit is 0, the number cannot be a palindrome
        // unless the number is 0 itself.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;

        // We only need to reverse half of the number to compare with the other half.
        // When the original number is less than the reversed number, it means we've processed half of the digits.
        while (x > reversedHalf) {
            // Extract the last digit of the number and move it to the tens place of the reversed half.
            reversedHalf = reversedHalf * 10 + x % 10;
            // Drop the last digit from the original number.
            x /= 10;
        }

        // At the end of the loop, we have two cases:
        // 1. The length of the number is odd, and we need to discard the middle digit by reversedHalf / 10.
        // 2. The length of the number is even, and the reversed half should be equal to the number.
        return x == reversedHalf || x == reversedHalf / 10;
    }
}

/**
 * What if the number is too large??
 * Solution-reverse only half number
 *
 * Stop when x <= reversedHalf (means we've processed half the digits).
 * For even digits (e.g., 1221): both halves should be equal (x == reversedHalf).
 * For odd digits (e.g., 12321): middle digit doesn’t matter — remove it by reversedHalf/10
 */

//Time: O(log₁₀n) i.e. log₁₀(12321) or O(n) where n is the number of digits— same as brute force solution
//
//Space: O(1)

/**
 *  Why reverse only half?
 * Prevents potential integer overflow.
 * Slightly more efficient.
 * Interviewer favorite to check "thinking beyond brute force".
 */