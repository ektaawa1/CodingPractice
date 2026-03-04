package patternBased.dfsBfs;

/**
 * Return the maximum number of fish the fisher can catch if he chooses his starting cell optimally,
 * or 0 if no water cell exists.
 * Input: grid = [[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]]
 * Output: 7
 * Explanation: The fisher can start at cell (1,3) and collect 3 fish, then move to cell (2,3) and
 * collect 4 fish.
 *
 * Input: grid = [[1,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,1]]
 * Output: 1
 * Explanation: The fisher can start at cells (0,0) or (3,3) and collect a single fish.
 */
public class MaxNoOfFishInGrid {
    public int findMaxFish(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxFish = 0;

        if(grid == null || grid.length == 0){
            return 0;
        }

        for(int i = 0; i< rows; i++){
            for(int j = 0; j< cols; j++){
                if(grid[i][j] > 0){
                    int fish = dfs(grid, i, j, rows, cols);
                    maxFish = Math.max(maxFish, fish);
                }
            }
        }
        return maxFish;
    }

    private int dfs(int[][] grid, int i, int j, int rows, int cols){
        if(i <0 || j<0 || i>= rows || j>= cols || grid[i][j] == 0){
            return 0;
        }
        int fishCount = grid[i][j];//collect fish
        grid[i][j] = 0; //mark as visited
        //now check in all 4 directions
        fishCount += dfs(grid, i, j-1, rows, cols);
        fishCount += dfs(grid, i, j+1, rows, cols);
        fishCount += dfs(grid, i-1, j, rows, cols);
        fishCount += dfs(grid, i+1, j, rows, cols);

        return fishCount;
    }
}
/**
 This is like Max Area of Island
 but instead of counting cells, you sum values.
 Find the maximum total fish you can collect from a connected component.
 */
//Time: O(m × n)
//Space: O(m × n) worst-case recursion
