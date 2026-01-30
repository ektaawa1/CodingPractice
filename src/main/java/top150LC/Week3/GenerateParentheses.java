package top150LC.Week3;

import java.util.ArrayList;
import java.util.List;

// 22. Generate Parentheses
// Using Backtracking
// as we have to generate all possible valid combinations

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * Example 1: Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Example 2: Input: n = 1, Output: ["()"]
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> combStringList = new ArrayList<>();
        if(n == 0){
            return combStringList;
        }
        backtrack(combStringList, "", 0, 0, n);
        return combStringList;
    }

    private void backtrack(List<String> combStringList, String currStr, int openCount, int closeCount, int n) {

        if(currStr.length() == n*2){
            combStringList.add(currStr);
            return;
        }
        //  Option to add '(' — try this branch
        if(openCount<n){ // we never exceed n value
            backtrack(combStringList, currStr+ "(", openCount+1, closeCount, n);
        }

        // Option to add ')' — try this branch
        if(closeCount < openCount){ //we never allow more close braces than open braces
            backtrack(combStringList, currStr+ ")", openCount, closeCount+1,n);
        }
    }
}

//Explanation-
//You explore BOTH choices whenever possible — left side of recursion for '(', right side for ')'.
//
//        This is what ensures all possible valid combinations are explored — no possibility missed.
//""
//        |
//        |-- Add '('  --> "("
//        |
//        |-- Add '('  --> "(("
//        |       |
//        |       |-- Add ')'  --> "(()"
//        |               |
//        |               |-- Add ')'  --> "(())"  ✅ VALID → ADD TO RESULT
//        |
//                |-- Add ')'  --> "()"
//        |
//        |-- Add '('  --> "()(("
//        |       |
//        |       |-- invalid: close > open (not allowed)
//        |
//        |-- Add ')'  --> "()()" ✅ VALID → ADD TO RESULT

//Time Complexity: O(4^n / √n) → you can say roughly O(4^n).

//Space Complexity: O(4^n / √n) → again, roughly O(4^n).