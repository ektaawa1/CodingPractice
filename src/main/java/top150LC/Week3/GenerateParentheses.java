package org.Week3;

import java.util.ArrayList;
import java.util.List;

// 22. Generate Parentheses
// Using Backtracking
// as we have to generate all possible valid combinations
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> combString = new ArrayList<>();
        backtrack(combString, "", 0, 0, n);
        return combString;
    }

    private void backtrack(List<String> combString, String currStr, int openCount, int closeCount, int n) {
//        if(openCount>n || closeCount>n || openCount<closeCount){ // this check is not needed as below its already being checked
//            return;
//        }//We can put explicit guards like (open > n) but our branching ensures such states are unreachable.

        if(currStr.length() == n*2){
            combString.add(currStr);
            return;
        }
        //  Option to add '(' — try this branch
        if(openCount<n){ // we never exceed n value
            backtrack(combString, currStr+ "(", openCount+1, closeCount, n);
        }

        // Option to add ')' — try this branch
        if(closeCount < openCount){ //we never allow more close braces than open braces
            backtrack(combString, currStr+ ")", openCount, closeCount+1,n);
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

