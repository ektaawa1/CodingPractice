package patternBased.twoPointers;

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
    // Optimized Solution- Inplace
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length()-1;

        while(l < r) {
            //Move the left pointer forward until it points to a valid letter or digit.
            while(l < r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            //Move the right pointer backward until it points to a valid letter or digit.
            while(r > l && !Character.isLetterOrDigit(s.charAt(r))){
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

    //TC = O(n), SC = O(n)
    public boolean isPalindromeBruteForce(String s) {
        if(s == null || s.isEmpty()){
            return true;
        }
        StringBuilder sb = new StringBuilder(); //SC = O(n)
        for(char ch: s.toCharArray()){
            if(Character.isLetterOrDigit(ch)){
                sb.append(Character.toLowerCase(ch));
            }
        }
        String s1 = sb.toString();
        int left = 0; int right = s1.length()-1;

        while(left < right){
            if(s1.charAt(left) != s1.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
//TC = O(n)
//SC = O(1)