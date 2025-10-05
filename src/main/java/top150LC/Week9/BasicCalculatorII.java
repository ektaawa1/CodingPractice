package top150LC.Week9;
// 227. Basic Calculator II
/**
 * Given a string s which represents an expression, evaluate this expression and return its value.
 * The integer division should truncate toward zero.
 * You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].
 */

import java.util.Stack;

/**
 * Example 1: Input: s = "3+2*2", Output: 7
 * Example 2: Input: s = " 3/2 ", Output: 1
 * Example 3: Input: s = " 3+5 / 2 ", Output: 5
 *
 * Constraints:
 * 1 <= s.length <= 3 * 105
 * s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
 * s represents a valid expression.
 * All the integers in the expression are non-negative integers in the range [0, 231 - 1].
 * The answer is guaranteed to fit in a 32-bit integer.
 */
public class BasicCalculatorII {
    public int calculate1(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int currNum = 0;
        char op = '+';

        // if(s.length() == 0 || s.equals(null)){
        //     return result;
        // }

        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                currNum = currNum * 10 + (ch-'0');
            }

            if((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1){
                switch(op){
                    case '+':
                        stack.push(currNum);
                        break;
                    case '-':
                        stack.push(-currNum);
                        break;
                    case '*':
                        stack.push(stack.pop() * currNum);
                        break;
                    case '/':
                        stack.push(stack.pop() / currNum);
                        break;
                }
                op = ch;
                currNum = 0;
            }
        }
        while(!stack.isEmpty()){
            result = result + stack.pop();
        }
        return result;
    }
    //Without Using Stack
    public int calculate(String s) {
        int result = 0;      // cumulative result
        int prevNum = 0;     // last number to handle * and /
        int currNum = 0;     // current number being processed
        char op = '+';       // previous operator

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + (ch - '0');
            }

            // If operator or last char
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                switch (op) {
                    case '+':
                        result += prevNum;  // add previous number
                        prevNum = currNum;  // update prevNum
                        break;
                    case '-':
                        result += prevNum;
                        prevNum = -currNum;
                        break;
                    case '*':
                        prevNum = prevNum * currNum;
                        break;
                    case '/':
                        prevNum = prevNum / currNum;
                        break;
                }
                op = ch;
                currNum = 0;
            }
        }

        result += prevNum;  // add the last number
        return result;
    }
}
