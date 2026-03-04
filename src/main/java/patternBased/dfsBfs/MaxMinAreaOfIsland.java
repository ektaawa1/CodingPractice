package patternBased.dfsBfs;
//Was asked in screening round of Oracle
//0 being white pixel, 1 means color pixel, I have to find out the minCount & maxCount of 1s joined together in
//all 4 directions.

import java.util.Arrays;
import java.util.List;

public class MaxMinAreaOfIsland {
    public int[] minMaxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return new int[]{0, 0};
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int minArea = Integer.MAX_VALUE;
        int maxArea = 0;

        for(int i = 0; i< rows; i++){
            for(int j = 0; j< cols; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, i, j, rows, cols);
                    minArea = Math.min(minArea, area);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        if(minArea == Integer.MAX_VALUE){
            minArea = 0;
        }
        return new int[]{minArea, maxArea};
    }

    private int dfs(int[][] grid, int i, int j, int rows, int cols) {
        if(i<0 || i>=rows || j<0 || j>= cols || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0; //mark it visited
        int area = 1;

        area += dfs(grid, i, j-1, rows, cols);
        area += dfs(grid, i, j+1, rows, cols);
        area += dfs(grid, i-1, j, rows, cols);
        area += dfs(grid, i+1, j, rows, cols);

        return area;
    }
    //=====================================================================================================
    //If using a boolean array for marking visited
    public List<Integer> findMinMaxIslands(List<List<Integer>> grid) {

        if (grid == null || grid.size() == 0)
            return Arrays.asList(0, 0);

        int rows = grid.size();
        int cols = grid.get(0).size();

        boolean[][] visited = new boolean[rows][cols];

        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid.get(i).get(j) == 1 && !visited[i][j]) {

                    int area = dfs(grid, visited, i, j);
                    min = Math.min(min, area);
                    max = Math.max(max, area);
                }
            }
        }

        if (max == 0) return Arrays.asList(0, 0);

        return Arrays.asList(min, max);
    }

    private int dfs(List<List<Integer>> grid, boolean[][] visited, int r, int c) {

        int rows = grid.size();
        int cols = grid.get(0).size();

        // boundary checks
        if (r < 0 || c < 0 || r >= rows || c >= cols)
            return 0;

        if (grid.get(r).get(c) == 0 || visited[r][c])
            return 0;

        visited[r][c] = true;

        int count = 1;

        count += dfs(grid, visited, r + 1, c);
        count += dfs(grid, visited, r - 1, c);
        count += dfs(grid, visited, r, c + 1);
        count += dfs(grid, visited, r, c - 1);

        return count;
    }
}
//Time Complexity: O(rows × cols)
//
//Space Complexity: O(rows × cols) worst-case recursion stack
