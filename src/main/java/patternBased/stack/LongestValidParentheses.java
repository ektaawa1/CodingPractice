package patternBased.stack;
//32. Longest Valid Parentheses

import java.util.Stack;

/**
 * Given a string containing just the characters '(' and ')',
 * return the length of the longest valid (well-formed) parentheses substring.
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stck = new Stack<>();
        stck.push(-1);//base index, to correctly calculate length
        int maxLen = 0;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stck.push(i);
            } else {
                stck.pop();
                if(stck.isEmpty()){//if stack is empty it means We found a closing bracket with NO matching '(', This position is INVALID, Valid substring cannot cross this point
                    stck.push(i); //mark it a new boundary/ new base index
                }else {
                    maxLen = Math.max(maxLen, i-stck.peek());
                }
            }
        }
        return maxLen;
    }
}
//Time Complexity = O(n)
//Space Complexity = O(n) (stack in worst case like "(((((")

/**
 * Why -1 ???     We need an index BEFORE the string starts
 * So length = i − base works even from index 0
 * Note-The stack stores indices of unmatched '(' AND the last invalid position
 * Example: s = "()" so 0-->( 1-->)
 * With stack = [-1], push index 0 ---> [-1,0]
 * Now, i = 1 → ')' so Pop → removes 0 which makes stack back to [-1]
 * stack is not empty so valid substring exists ---> length = 1-(-1) = 2 ✅ Correct answer
 * But if not initialized to -1 then output will be incorrect.
 * Say this if asked-
 * “We push -1 as a sentinel index representing a position before the string starts.
 * This allows us to compute correct lengths even when the valid substring begins at index 0.”
 */
/**
 * Input: s = "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()".
 * Input: s = ""
 * Output: 0
 *
 * where s[i] is '(', or ')'.
 */
