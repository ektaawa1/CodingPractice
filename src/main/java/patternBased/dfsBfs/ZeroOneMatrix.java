package patternBased.dfsBfs;
//542. 01 Matrix

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * The distance between two cells sharing a common edge is 1.
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 */
public class ZeroOneMatrix {
    //This is Multi-source BFS
    public int[][] updateMatrix(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Initialize queue with all 0s
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(mat[i][j] == 0){
                    queue.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1; // mark unvisited
                    //Why Do We Mark 1s as -1? because we have to find the sum and if sum come out to be 1 it gets
                    //ambiguous so changing to -1.
                }
            }
        }

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // Step 2: BFS
        while(!queue.isEmpty()){

            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];

            for(int[] dir : directions){

                int newRow = r + dir[0];
                int newCol = c + dir[1];

                if(newRow >= 0 && newRow < rows &&
                        newCol >= 0 && newCol < cols &&
                        mat[newRow][newCol] == -1){

                    mat[newRow][newCol] = mat[r][c] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return mat;
    }
}
/**
 Keyword: nearest 0
 This means:
 Shortest path
 Unweighted graph
 Many 0s
 This is Multi-source BFS

 Instead of:
 For every 1 → find nearest 0 (too slow)
 We do:
 Push all 0s into queue first, then expand outward.

 Time: O(m × n)
 Each cell visited once.

 Space: O(m × n)
 Queue worst case.
 */

/**
 * We convert all 1s to -1 to mean: “This cell has NOT been processed yet.”
 * Then during BFS:
 * if(mat[newRow][newCol] == -1)
 * That condition means:
 * This cell has never been assigned a distance yet.
 * So we assign it: mat[newRow][newCol] = mat[r][c] + 1;   Once assigned:
 * It becomes 1, 2, 3, etc.
 * It will never again equal -1. So it won’t be revisited.
 */
