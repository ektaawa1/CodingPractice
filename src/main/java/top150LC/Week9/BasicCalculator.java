package top150LC.Week9;
//224. Basic Calculator

import java.util.Stack;

/**
 * Given a string s representing a valid expression, implement a basic calculator to
 * evaluate it, and return the result of the evaluation.
 * Example 1: Input: s = "1 + 1", Output: 2
 * Example 2: Input: s = " 2-1 + 2 ", Output: 3
 * Example 3: Input: s = "(1+(4+5+2)-3)+(6+8)", Output: 23
 * Constraints:
 * 1 <= s.length <= 3 * 105
 * s consists of digits, '+', '-', '(', ')', and ' '.
 */
public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int currNum = 0;
        int sign = 1; //default is +ve

        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                currNum = currNum * 10 + (ch-'0');
            }else if(ch == '+'){
                result = result + (sign * currNum);
                currNum = 0;
                sign = 1;
            } else if(ch == '-'){
                result = result + (sign * currNum);
                currNum = 0;
                sign = -1;
            } else if(ch == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if(ch == ')'){
                result = result + (sign * currNum);
                currNum = 0;
                result = result * stack.pop();//sign before '('
                result = result + stack.pop();//result before '('
            }//ignore space
        }
        result = result + (sign * currNum);//add last number
        return result;
    }
}
