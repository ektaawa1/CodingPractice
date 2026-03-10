package patternBased.graph.dfsBfs;
// 1254. Number of Closed Islands

/**
 * Given a 2D grid consists of 0s (land) and 1s (water).
 * An island is a maximal 4-directionally connected group of 0s and a closed island
 * is an island totally (all left, top, right, bottom) surrounded by 1s.
 * Return the number of closed islands.
 * Input: grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * Output: 2
 * Input: grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * Output: 1
 * Input: grid = [[1,1,1,1,1,1,1],
 *                [1,0,0,0,0,0,1],
 *                [1,0,1,1,1,0,1],
 *                [1,0,1,0,1,0,1],
 *                [1,0,1,1,1,0,1],
 *                [1,0,0,0,0,0,1],
 *                [1,1,1,1,1,1,1]]
 * Output: 2
 */
public class NoOfClosedIslands {
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;
        if(grid == null || grid.length == 0){
            return 0;
        }
        //check boundaries and remove if any land is found
        //rows 0th & rows-1
        for(int j = 0; j  <cols; j++){
            dfs(grid, 0, j, rows, cols);
            dfs(grid, rows-1, j, rows, cols);
        }
        //cols 0th & cols-1
        for(int i = 0; i < rows; i++){
            dfs(grid, i, 0, rows, cols);
            dfs(grid, i, cols-1, rows, cols);
        }
        for(int i = 0; i<rows; i++){
            for(int j = 0; j< cols; j++){
                if(grid[i][j] == 0){
                    count++;
                    //now explore its neighbors
                    dfs(grid, i, j, rows, cols);
                }
            }
        }
        return count;
    }
    private void dfs(int[][] grid, int i, int j, int rows, int cols){
        if(i < 0 || j<0 || i >= rows || j >= cols || grid[i][j] == 1){
            return;
        }
        grid[i][j] = 1;//converting all border 0s to 1s as have to exclude from counting
        //explore the 4 neighbors
        dfs(grid, i-1, j, rows, cols);
        dfs(grid, i+1, j, rows, cols);
        dfs(grid, i, j-1, rows, cols);
        dfs(grid, i, j+1, rows, cols);
    }
}
//Time: O(m × n)
//Space: O(m × n) recursion stack worst case
