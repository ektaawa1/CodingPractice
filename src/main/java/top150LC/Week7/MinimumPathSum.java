package top150LC.Week7;

import java.util.List;

/**
 * Intuition (Why DP is Needed)
 * At each row, you have choices:
 * From 2 → you can go to 3 or 4.
 * From 3 → you can go to 6 or 5.
 * From 4 → you can go to 5 or 7.
 *
 * If you try to explore all paths, it’s exponential (too slow).
 * So, we need Dynamic Programming (DP) to reuse results.
 */

public class MinimumPathSum {
    //Using Dynamic Programming Approach
    public int minimumTotal(List<List<Integer>> triangle) {
        int rowLen = triangle.size();
        int arr[] = new int[rowLen];

        // fill the last row elements in the array
        for(int i = 0; i<rowLen; i++){
            arr[i] = triangle.get(rowLen-1).get(i); // [4,1,8,3]
        }

        //Bottom up calculation
        //now backtrack by finding the minimum of 2 elements & add it to the above row element
        for(int i = rowLen-2; i >= 0; i--){ // [6,5,7]
            for(int j = 0; j<= i; j++){
                arr[j] = triangle.get(i).get(j) + Math.min(arr[j], arr[j+1]);
            }
        }
        return arr[0]; // Minimum path sum from top to bottom
    }
}
//Time: O(n²) (since triangle has ~n² elements)
//Space: O(n) (we use 1D dp instead of full 2D table)

//Other Approach is using DFS+back tracking (recursion)
/**
 * Work bottom-up (not top-down).
 * Each step just says: “Pick me + min(child1, child2)”.
 *
 * Dry Run-
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 *
 * Step 1: Initialize dp with last row: dp = [4, 1, 8, 3]
 * Step 2: Process row 6, 5, 7
 * dp[0] = 6 + min(4, 1) = 7
 * dp[1] = 5 + min(1, 8) = 6
 * dp[2] = 7 + min(8, 3) = 10
 * dp = [7, 6, 10, 3]
 * Step 3: Process row 3, 4
 * dp[0] = 3 + min(7, 6) = 9
 * dp[1] = 4 + min(6, 10) = 10
 * dp = [9, 10, 10, 3]
 *Step 4: Process row 2
 * dp[0] = 2 + min(9, 10) = 11
 * dp = [11, 10, 10, 3]
 *
 * Answer = dp[0] = 11
 */
