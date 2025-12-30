package top150LC.Week7;
//200. Number of Islands

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 */

public class NumOfIslands {
    //DFS Approach
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0; // no islands
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid, i, j); //bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int row, int col){
        //boundary condition
        if(row <0 || col <0 || row>= grid.length || col >= grid[0].length || grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0'; //mark it visited or sink the land

        //now visit the neighbors of that land
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
    }
    //if using bfs logic
    private void bfs(char[][] grid, int r, int c) {
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{r, c});
        grid[r][c] = '0'; // mark visited

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            for (int[] d : dirs) {
                int nr = row + d[0];
                int nc = col + d[1];

                if (nr >= 0 && nr < grid.length &&
                        nc >= 0 && nc < grid[0].length &&
                        grid[nr][nc] == '1') {

                    queue.offer(new int[]{nr, nc});
                    grid[nr][nc] = '0'; // mark visited
                }
            }
        }
    }
}
}

/**
 * Intuition:
 * This is a connected components problem.
 * Loop through all cells.
 * When we find a '1' (land not visited yet):
 * Count it as a new island.
 * Run DFS or BFS to "sink" (mark visited) all connected land.
 */

/**
 * Time Complexity: O(m * n) → each cell visited once.
 * Space Complexity:
 * DFS: O(m * n) (recursion stack in worst case).
 * BFS: O(min(m,n)) queue in worst case (if entire row/col is land).
 */
