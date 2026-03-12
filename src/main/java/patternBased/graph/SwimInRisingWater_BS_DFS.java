package patternBased.graph;

public class SwimInRisingWater_BS_DFS {
    public int swimInWater(int[][] grid) {

        int n = grid.length;

        int low = grid[0][0];
        int high = n * n - 1; //given in question constraints

        while (low < high) {
            int mid = (low + high) / 2;

            boolean[][] visited = new boolean[n][n];

            if (dfs(grid, 0, 0, mid, visited)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
    private boolean dfs(int[][] grid, int r, int c, int time, boolean[][] visited){

        int n = grid.length;

        if(r<0 || c<0 || r>=n || c>=n) return false;

        if(visited[r][c] || grid[r][c] > time) return false;

        if(r == n-1 && c == n-1) return true;

        visited[r][c] = true;

        return dfs(grid,r+1,c,time,visited) ||
                dfs(grid,r-1,c,time,visited) ||
                dfs(grid,r,c+1,time,visited) ||
                dfs(grid,r,c-1,time,visited);
    }
}
