package org.Week2;

// 20. Valid Parentheses

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 * Example 1: Input: s = "()", Output: true
 * Example 2: Input: s = "()[]{}", Output: true
 * Example 3: Input: s = "(]", Output: false
 * Example 4: Input: s = "([])", Output: true
 */

// https://algo.monster/liteproblems/20
//Stack LIFO
public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c: s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else {
                if (stack.isEmpty() || !match(stack.pop(),c)){
                    return false;
                }
            }
        }
        // If the stack is empty, all brackets were matched correctly
        return stack.isEmpty();
    }

    private boolean match(char leftBracket, char rightBracket) {
        // Return true if pairs match, false otherwise
        return (leftBracket == '(' && rightBracket == ')') ||
                (leftBracket == '{' && rightBracket == '}') ||
                (leftBracket == '[' && rightBracket == ']');
    }
}

//TC = O(n)
//SC = O(n)
/**
 * Best Case: When the string is empty or consists of a single pair of brackets,
 * the time complexity is O(1) because it takes a constant amount of time.
 * Average Case: For a typical string with a mix of opening and closing brackets,
 * the time complexity remains O(n) because each character is processed once.
 * Worst Case: In the worst case scenario, where there are n characters and the string is
 * properly nested to the deepest level, each character is still processed exactly once,
 * giving us a time complexity of O(n).
 *
 * The space complexity is O(n) which occurs when all characters are opening brackets and hence,
 * all are pushed onto the stack. This represents the maximum space utilized by the algorithm.
 */
