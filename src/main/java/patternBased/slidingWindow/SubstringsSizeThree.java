package patternBased.slidingWindow;
// 1876. Substrings of Size Three with Distinct Characters
/**
 * A string is good if there are no repeated characters.
 * Given a string s, return the number of good substrings of length three in s.
 * Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
 * A substring is a contiguous sequence of characters in a string.
 */
public class SubstringsSizeThree {
    public int countGoodSubstrings(String s) {
        //we need to count substrings if there are no repeated characters.
        //size = 3 fixed size
        // 1st take a 3 size substring as a good string
        //Then add one character from right and remove one character from the left side
        //Now from the substring array, count only those where no repeated character is there.
        //Return the count.

        if(s.length() < 3){
            return 0;
        }

        int count = 0;
        int len = s.length()-3; // i, i+1, i+2
        for(int i = 0; i<= len; i++){ //Every valid window is covered. Nothing is skipped. Avoids Index out of bounds
            char a = s.charAt(i);
            char b = s.charAt(i+1);
            char c = s.charAt(i+2); //i + 2 must be a valid index that is why i <= s.length()-3

            if(a != b && b != c && c != a){
                count++;
            }
        }
        return count;
    }
}
//Why no HashSet?? Since the window size is fixed at 3, direct character comparison is more efficient than maintaining a set.
/**
 * Example 1:
 * Input: s = "xyzzaz"
 * Output: 1
 * Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
 * The only good substring of length 3 is "xyz".
 *
 * Example 2:
 * Input: s = "aababcabc"
 * Output: 4
 * Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
 * The good substrings are "abc", "bca", "cab", and "abc".
 */
