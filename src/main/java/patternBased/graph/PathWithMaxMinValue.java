package patternBased.graph;

// "maximize the minimum” path pattern

import java.util.PriorityQueue;

/**
 * You are given an m x n grid of integers. You start at: (0,0)
 * You want to reach: (m-1,n-1)
 * You can move: up, down, left, right
 * The score of a path is defined as: minimum value in that path
 * Your goal: Return the maximum score possible among all paths.
 */
public class PathWithMaxMinValue {
    //Use Max Heap + BFS (Dijkstra style).
    public int maximumMinimumPath(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<int[]> maxHeap =
                new PriorityQueue<>((a, b)-> b[0]-a[0]);

        boolean[][] visited = new boolean[m][n];

        maxHeap.offer(new int[]{grid[0][0],0,0});

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!maxHeap.isEmpty()){

            int[] curr = maxHeap.poll();

            int score = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(r == m-1 && c == n-1){
                return score;
            }

            visited[r][c] = true;

            for(int[] d : dirs){

                int nr = r + d[0];
                int nc = c + d[1];

                if(nr>=0 && nc>=0 && nr<m && nc<n && !visited[nr][nc]){

                    int newScore = Math.min(score, grid[nr][nc]);

                    maxHeap.offer(new int[]{newScore,nr,nc});
                }
            }
        }

        return -1;
    }
}

/**
 * Example:
 * grid =
 * [
 *  [5,4,5],
 *  [1,2,6],
 *  [7,4,6]
 * ]
 * Possible path--> 5 → 4 → 5 → 6 → 6 with min value = 4
 * Another path --> 5 → 1 → 7 → 4 → 6 with min value = 1
 * We want the maximum of these minimums so output = 4.
 * This is the reverse of: Swim in Rising Water
 * There we minimized the maximum elevation.
 * Here we maximize the minimum cell value.
 */
