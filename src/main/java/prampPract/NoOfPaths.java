package prampPract;

import java.io.*;
import java.util.*;

/**
 * input:  n = 4
 * output: 5 # since there are five possibilities:
 *           # “EEENNN”, “EENENN”, “ENEENN”, “ENENEN”, “EENNEN”,
 *           # where the 'E' character stands for moving one step
 *           # East, and the 'N' character stands for moving one step
 *           # North (so, for instance, the path sequence “EEENNN”
 *           # stands for the following steps that the car took:
 *           # East, East, East, North, North, North)
 */

/**
 * DP definition and recurrence
 * Define dp[i][j] = number of valid paths from start (0,0) to (i, j).
 * To reach (i, j) you must come from either:
 * the cell to the west: (i-1, j) (then you moved East),
 * or the cell to the south: (i, j-1) (then you moved North).
 * So the recurrence:
 * dp[i][j] = dp[i-1][j] + dp[i][j-1]
 */
class NoOfPaths {

    static int numOfPathsToDest(int n) {
        // your code goes here
        // TC = O(n^2)- DP Solution (DFS/BFS will be O(2^(2n)) not efficient- Brute Force)
        // The number of possible paths explodes combinatorially. Brute force (DFS) would explore every path — too slow.
        //SC = O(n^2)
        int pathCount = 0;
        int [][] dpArr = new int [n][n];
        dpArr[0][0] = 1;
        for(int i = 0; i< n; i++){
            for(int j = 0; j<n; j++){
                if (i < j) {
                    dpArr[i][j] = 0; // above diagonal, forbidden
                    continue;
                }
                if (i == 0 && j == 0) continue;
                int ways = 0;
                if (i > 0) ways += dpArr[i-1][j]; // from west
                if (j > 0) ways += dpArr[i][j-1]; // from south
                dpArr[i][j] = ways;
            }
        }
        return dpArr[n-1][n-1];
    }
    // O(n) space
    public int numOfPathsToDestOptimized(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    dp[j] = 0;
                } else {
                    if (j > 0) dp[j] = dp[j] + dp[j-1]; // dp[j] is old dp[i-1][j], dp[j-1] is dp[i][j-1]
                    // else j==0 -> dp[j] stays as dp[i][0] (which is 1 for i>=0)
                }
            }
        }
        return dp[n-1];
    }

    public static void main(String[] args) {

    }
// Brute Force Solution-BFS approach
    public int numOfPathsBFS(int n) {
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0}); // start at (0,0)

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int i = cell[0], j = cell[1];

            // Reached destination
            if (i == n-1 && j == n-1) {
                count++;
                continue;
            }

            // Move East
            if (i+1 < n && (i+1) >= j) {
                q.offer(new int[]{i+1, j});
            }

            // Move North
            if (j+1 < n && i >= (j+1)) {
                q.offer(new int[]{i, j+1});
            }
        }

        return count;
    }
}
/**
 * Step-by-step example: n = 4 (indices 0..3), We want dp[3][3]
 *
 *  j=3:  (0,3)=0   (1,3)=0   (2,3)=0   (3,3)=5
 *  j=2:  (0,2)=0   (1,2)=0   (2,2)=2   (3,2)=5
 *  j=1:  (0,1)=0   (1,1)=1   (2,1)=2   (3,1)=3
 *  j=0:  (0,0)=1   (1,0)=1   (2,0)=1   (3,0)=1
 *         i=0       i=1       i=2       i=3
 */

//Question-
/**
 * You’re testing a new driverless car that is located at the Southwest (bottom-left) corner of an n×n grid.
 * The car is supposed to get to the opposite, Northeast (top-right), corner of the grid. Given n, the size of
 * the grid’s axes, write a function numOfPathsToDest that returns the number of the possible paths the
 * driverless car can take. The car may move only in the white squares
 * For convenience, let’s represent every square in the grid as a pair (i,j). The first coordinate in the pair
 * denotes the east-to-west axis, and the second coordinate denotes the south-to-north axis. The initial state
 * of the car is (0,0), and the destination is (n-1,n-1). The car must abide by the following two rules:
 * it cannot cross the diagonal border. In other words, in every step the position (i,j) needs to maintain i >= j.
 * See the illustration above for n = 5.
 * In every step, it may go one square North (up), or one square East (right), but not both.
 * E.g. if the car is at (3,1), it may go to (3,2) or (4,1).
 */

/**
 * How these were computed (walk-through):
 *
 * Start: dp[0][0] = 1.
 *
 * Row j = 0 (bottom row): i >= j so allowed.
 *
 * dp[1][0] = dp[0][0] + dp[1][-1](=0) = 1
 *
 * dp[2][0] = dp[1][0] + dp[2][-1](=0) = 1
 *
 * dp[3][0] = 1
 *
 * (Any dp[i][0] is 1 because there's only one way: move East repeatedly.)
 *
 * Row j = 1:
 *
 * dp[0][1] is invalid because i < j (0 < 1) → 0.
 *
 * dp[1][1] = dp[0][1] + dp[1][0] = 0 + 1 = 1
 *
 * dp[2][1] = dp[1][1] + dp[2][0] = 1 + 1 = 2
 *
 * (Paths to (2,1) come from (1,1) and (2,0).)
 *
 * dp[3][1] = dp[2][1] + dp[3][0] = 2 + 1 = 3
 *
 * Row j = 2:
 *
 * dp[0][2] and dp[1][2] invalid (i<j) → 0.
 *
 * dp[2][2] = dp[1][2] + dp[2][1] = 0 + 2 = 2
 *
 * dp[3][2] = dp[2][2] + dp[3][1] = 2 + 3 = 5
 *
 * Row j = 3:
 *
 * only dp[3][3] valid (i must be ≥ 3):
 *
 * dp[3][3] = dp[2][3] + dp[3][2] = 0 + 5 = 5
 *
 * So final answer dp[3][3] = 5 (matches Catalan C3 = 5).
 */
