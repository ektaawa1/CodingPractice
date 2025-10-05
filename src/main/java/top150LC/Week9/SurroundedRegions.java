package top150LC.Week9;
//130. Surrounded Regions

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
// Step 1: Mark boundary-connected 'O's
        for(int j = 0; j <cols; j++){
            dfs(board, 0, j); // top boundary
            dfs(board, rows-1, j); // bottom boundary
        }

        for(int i = 0; i < rows; i++){
            dfs(board, i, 0); // left boundary
            dfs(board, i, cols-1); // right boundary
        }
// Step 2: Flip the cells
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X'; // captured
                }else if(board[i][j] == 'S'){
                    board[i][j] = 'O'; // safe
                }
            }
        }
    }
    private void dfs(char[][] board, int i, int j){
        int r = board.length;
        int c = board[0].length;

        if(i<0 ||i>= r || j<0 || j>= c || board[i][j] != 'O'){
            return;
        }
        board[i][j] = 'S'; // Mark as safe

        dfs(board, i, j-1);
        dfs(board, i, j+1);
        dfs(board, i-1, j);
        dfs(board, i+1, j);
    }
// Using BFS approach
    public void solve1(char[][] board) {
        if (board == null || board.length == 0) return;
        int m = board.length;
        int n = board[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Add all boundary 'O's into queue
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
            }
            if (board[i][n - 1] == 'O') {
                queue.offer(new int[]{i, n - 1});
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                queue.offer(new int[]{0, j});
            }
            if (board[m - 1][j] == 'O') {
                queue.offer(new int[]{m - 1, j});
            }
        }

        // Step 2: BFS to mark all safe 'O's
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];

            if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != 'O') {
                continue;
            }

            board[i][j] = 'S'; // mark safe

            // 4 directions
            queue.offer(new int[]{i + 1, j});
            queue.offer(new int[]{i - 1, j});
            queue.offer(new int[]{i, j + 1});
            queue.offer(new int[]{i, j - 1});
        }

        // Step 3: Flip the cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';   // captured
                } else if (board[i][j] == 'S') {
                    board[i][j] = 'O';   // safe
                }
            }
        }
    }
}

//Time: O(m * n) (each cell visited at most once).
//Space: O(m * n) recursion stack in worst case (can optimize using BFS + queue to O(min(m, n))).

/**
 * You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:
 * Connect: A cell is connected to adjacent cells horizontally or vertically.
 * Region: To form a region connect every 'O' cell.
 * Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
 * To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.
 */

/**
 * BFS Approach: Queue<int[]> queue = new LinkedList<>();
 * Instead of recursion, we’ll use a queue:
 * Start from all boundary 'O' cells.
 * For each boundary 'O', push into queue and mark it as 'S'.
 * While queue is not empty, pop one cell and check its 4 directions. If neighbor is 'O', mark as 'S' and add to queue.
 * Finally, flip:
 * All 'O' → 'X'
 * All 'S' → 'O'
 */
