package top75LC.Week2;
//BFS Approach

import java.util.LinkedList;
import java.util.Queue;

/**
 * You’re given a grid:
 *0 → empty cell, 1 → fresh orange, 2 → rotten orange
 *
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 * If this is impossible, return -1.
 */

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0;
        Queue<int[]> rottenQ = new LinkedList<>();

        //STEP 1: Count all fresh and rotten oranges
        for(int i = 0; i< rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == 2){
                    rottenQ.offer(new int[]{i,j});
                }else if(grid[i][j] == 1){
                    freshCount++;
                }
            }
        }
        if(freshCount == 0){
            return 0;
        }

        int mins = 0;
        int directions[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}}; // All directions
        //STEP 2: BFS
        while(!rottenQ.isEmpty() && freshCount >0){
            int size = rottenQ.size(); // process one level
            for (int i = 0; i < size; i++) {
                int curr[] = rottenQ.poll();
                int r = curr[0];
                int c = curr[1];

                for(int[] dir: directions){
                    int nr = dir[0] + r;
                    int nc = dir[1] + c;

                    if(nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == 1){
                        grid[nr][nc] = 2; //rot it
                        rottenQ.offer(new int[]{nr,nc});
                        freshCount--;
                    }
                }
            }
            mins++; // one minute passed after finishing the level
        }
        return freshCount == 0 ? mins : -1;
    }
}

//TC = O(m*n) This is because in the worst case, we may have to look at each cell in the grid.
//SC = O(m*n) This is due to the queue which in the worst case might need to store all the
// cells if they are all rotten oranges

/**
 * Approach (BFS Infection Spread 🔁)
 * Start BFS from all initially rotten oranges.
 * Keep track of fresh oranges.
 * For each minute, infect the 4 neighboring cells (up, right, down, left).
 * Count how many fresh got infected.
 * If all fresh oranges get infected ➡️ return time.
 * If not ➡️ return -1.
 */

