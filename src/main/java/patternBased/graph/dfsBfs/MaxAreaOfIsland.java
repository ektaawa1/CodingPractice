package patternBased.graph.dfsBfs;
// 695. Max Area of Island
/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 * The area of an island is the number of cells with a value 1 in the island.
 * Return the maximum area of an island in grid. If there is no island, return 0.
 */
public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int maxArea = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        //TC = O(rows*cols)
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, rows, cols, i,j);//You must count all connected cells of that island.
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    private int dfs(int[][] grid, int rows, int cols, int i, int j){
        //DFS must return the area
        if(i<0 || i>=rows || j<0 || j>= cols || grid[i][j] == 0){
            return 0;
        }
        int area = 1;
        grid[i][j] = 0; //mark it visited

        area += dfs(grid, rows, cols, i, j+1);
        area += dfs(grid, rows, cols, i, j-1);
        area += dfs(grid, rows, cols, i+1, j);
        area += dfs(grid, rows, cols, i-1, j);

        return area;
    }
}
/**
 When you find a 1:
 Call DFS
 DFS explores entire island
 DFS returns total area
 Compare with maxArea */
//TC = O(rows*cols)
//SC = Recursion stack --> DFS depth could be O(m × n) --> SC = O(m × n) worst case
