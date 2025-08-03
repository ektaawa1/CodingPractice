package top75LC.Week2;

import java.util.Stack;

/**
 * You are given a string s, which contains stars *.
 * In one operation, you can:
 * Choose a star in s.
 * Remove the closest non-star character to its left, as well as remove the star itself.
 * Return the string after all stars have been removed.
 *
 *  Example 1: Input: s = "leet**cod*e", Output: "lecoe"
 */
public class RemoveStarsFromStr {
    public String removeStarsUsingStringBuilder(String s) {
        StringBuilder str = new StringBuilder();
        for(char ch: s.toCharArray()){
            if(ch != '*'){
                str.append(ch);
            }else{
                str.deleteCharAt(str.length()-1);
            }
        }
        return str.toString();
    }
    public String removeStarsUsingStack(String s) {
        Stack<Character> strStack = new Stack<>();

        for(char ch:s.toCharArray()){
            if(ch != '*'){
                strStack.push(ch);
            }else {
                strStack.pop();
            }
        }
        // Build the final string from stack
        StringBuilder result = new StringBuilder();
        for (char ch : strStack) {
            result.append(ch);
        }

        return result.toString();
    }
}

//TC = O(n)
//SC = O(n)

/**
 * Why StringBuilder & not Stack for efficient solution?
 * Using StringBuilder is more efficient here because it stores plain characters directly,
 * unlike Stack<Character>, which stores each letter as an object — taking more memory.
 * Also, Stack is thread-safe, which adds overhead, but that’s unnecessary for this single-threaded
 * problem. So StringBuilder gives the same behavior with better performance and less memory use.
 *
 * StringBuilder is not synchronized, so:
 * It's faster for single-threaded code (like 99% of coding interviews)
 * Uses less memory and CPU
 *
 * Stack<Character> = Every letter (char)  you push is being wrapped (boxed) into a Character object.
 * StringBuilder = Just stores raw characters — no wrapping, no fluff.
 */

/**
 * Stack Dry Run:
 * | Char | Action    | Stack Contents |
 * | ---- | --------- | -------------- |
 * | 'l'  | push      | l              |
 * | 'e'  | push      | l e            |
 * | 'e'  | push      | l e e          |
 * | 't'  | push      | l e e t        |
 * | '\*' | pop ('t') | l e e          |
 * | '\*' | pop ('e') | l e            |
 * | 'c'  | push      | l e c          |
 * | 'o'  | push      | l e c o        |
 * | 'd'  | push      | l e c o d      |
 * | '\*' | pop ('d') | l e c o        |
 * | 'e'  | push      | l e c o e      |
 */