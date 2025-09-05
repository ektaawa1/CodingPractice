package top75LC.Week1;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Example 1:
 *Input: s = "IceCreAm", Output: "AceCreIm"
 *
 * Example 2:
 * Input: s = "leetcode", Output: "leotcede"
 */
public class ReverseVowelsInString {
    // Two pointer approach
    public String reverseVowels(String s) {
        HashSet<Character> vowelSet = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
        int left = 0;
        int right = s.length()-1;
        char word[] = s.toCharArray();

        while(left<right){
            if(!vowelSet.contains(word[left])){
                left++;
            } else if(!vowelSet.contains(word[right])){
                right--;
            } else {
                char temp = word[left];
                word[left] = word[right];
                word[right] = temp;
                left++;
                right--;
            }
        }
        return new String(word);
    }
}
/**
 * Pseudocode Approach:
 * 1. Initialize a set of vowels (both lowercase and uppercase for safety)
 * 2. Convert the input string to a char array (since strings are immutable)
 * 3. Initialize two pointers:
 *     - left at 0
 *     - right at length - 1
 * 4. While left < right:
 *     - Move left forward until a vowel is found
 *     - Move right backward until a vowel is found
 *     - Swap the characters at left and right
 *     - Move both pointers inward
 * 5. Convert the char array back to a string and return
 */
