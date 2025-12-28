package otheTopicsExample;

/**
 * Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
 * A shift on s consists of moving the leftmost character of s to the rightmost position.
 *
 * For example, if s = "abcde", then it will be "bcdea" after one shift.
 *
 * Example 1:
 * Input: s = "abcde", goal = "cdeab"
 * Output: true
 *
 * Example 2:
 * Input: s = "abcde", goal = "abced"
 * Output: false
 */
public class RotateString {
    //TC = O(n^2), SC = O(n)
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) return false;

        String rotated = s;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            rotated = rotated.substring(1) + rotated.charAt(0);
            //"abcde".substring(1) → "bcde" AND "abcde".charAt(0) → 'a' ===> "bcde" + 'a' → "bcdea"
            if (rotated.equals(goal)) {
                return true;
            }
        }
        return false;
    }
    public boolean rotateStringOptimized(String s, String goal) {
        if(s.length() != goal.length()){
            return false;
        }
        return (s + s).contains(goal);
    }
}
// TC = O(n)
// SC = O(n)
/**
 * rotated.substring(1) + rotated.charAt(0); ==> will remove first character + append it at the end

 Using StringBuilder avoids repeated string creation, but deleting from the front still takes O(n), so overall time complexity remains O(n²). It does not significantly improve performance.
 */
