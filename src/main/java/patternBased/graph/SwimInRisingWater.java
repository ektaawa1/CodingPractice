package patternBased.graph;

import java.util.PriorityQueue;

//Minimize the Maximum Cost Path Pattern
// Solved using Dijkstra / MinHeap or Binary Search + BFS/DFS
public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {

        int n = grid.length;

        PriorityQueue<int[]> minHeap =
                new PriorityQueue<>((a,b)-> a[0]-b[0]);

        boolean[][] visited = new boolean[n][n];

        minHeap.offer(new int[]{grid[0][0],0,0});

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!minHeap.isEmpty()){

            int[] curr = minHeap.poll();

            int time = curr[0];
            int r = curr[1];
            int c = curr[2];

            if(r == n-1 && c == n-1){
                return time;
            }

            if(visited[r][c]) continue;
            visited[r][c] = true;

            for(int[] d : dirs){

                int nr = r + d[0];
                int nc = c + d[1];

                if(nr>=0 && nc>=0 && nr<n && nc<n && !visited[nr][nc]){

                    int newTime = Math.max(time, grid[nr][nc]);

                    minHeap.offer(new int[]{newTime,nr,nc});
                }
            }
        }

        return -1;
    }
}
//TC is O(N² log N²) or O(N² log N)
//SC is O(N²)
