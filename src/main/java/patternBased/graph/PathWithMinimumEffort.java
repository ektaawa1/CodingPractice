package patternBased.graph;
//1631. Path With Minimum Effort

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D array of size rows x columns,
 * where heights[row][col] represents the height of cell (row, col).
 * You are situated in the top-left cell, (0, 0), and you hope to travel to the bottom-right cell,
 * (rows-1, columns-1) (i.e., 0-indexed). You can move up, down, left, or right, and
 * you wish to find a route that requires the minimum effort.
 * A route's effort is the maximum absolute difference in heights between two consecutive cells of the route.
 * Return the minimum effort required to travel from the top-left cell to the bottom-right cell.
 * Input: heights = [[1,2,2],[3,8,2],[5,3,5]]
 * Output: 2
 * Explanation: The route of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
 * This is better than the route of [1,2,2,2,5], where the maximum absolute difference is 3.
 * Input: heights = [[1,2,3],[3,8,4],[5,3,5]]
 * Output: 1
 * Input: heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * Output: 0
 */
public class PathWithMinimumEffort {
    //Binary Search On Answer + BFS
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int low = 0;
        int high = 1000000; //given in constraints

        while(low<high){
            int mid = low + (high-low)/2;
            if(canReach(heights, mid, rows, cols)){
                high = mid;
            }else {
                low = mid + 1;
            }
        }
        return low;
    }
    private boolean canReach(int[][] heights, int limit, int rows, int cols){
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0,0});
        visited[0][0] = true;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];

            if(r == rows-1 && c == cols-1){
                return true;
            }

            for(int[] dir : directions){
                int nr = r+dir[0];
                int nc = c+dir[1];
                if(nr>=0 && nc>=0 && nr<rows && nc<cols
                        && !visited[nr][nc]){

                    int diff = Math.abs(
                            heights[r][c] - heights[nr][nc]
                    );

                    if(diff <= limit){

                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr,nc});
                    }
                }
            }
        }
        return false;
    }
}
