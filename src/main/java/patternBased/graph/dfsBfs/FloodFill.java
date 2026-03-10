package patternBased.graph.dfsBfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an image represented by an m x n grid of integers image, where image[i][j]
 * represents the pixel value of the image. You are also given three integers sr, sc, and color.
 * Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].
 *
 * Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // BFS Approach
        int currColor = image[sr][sc];
        if(currColor == color) return image; // nothing to change

        int rLen = image.length;
        int cLen = image[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr,sc});

        while(!queue.isEmpty()){
            int pair[] = queue.poll();
            int r = pair[0];
            int c = pair[1];

            // only process if it’s the currColor
            if(image[r][c] == currColor){
                image[r][c] = color;

                if(r>0) queue.add(new int[]{r-1, c}); //up
                if(r<rLen-1) queue.add(new int[]{r+1, c}); //down
                if(c>0) queue.add(new int[]{r, c-1}); //left
                if(c<cLen-1) queue.add(new int[]{r, c+1}); //right
            }
        }
        return image;
    }

    public int[][] floodFillDFS(int[][] image, int sr, int sc, int color) {
        // DFS Approach
        if(image == null || image.length == 0){
            return new int[][]{};
        }

        int rows = image.length;
        int cols = image[0].length;
        int startPixel = image[sr][sc];

        // If starting pixel is already the new color, no need to process
        if(startPixel == color){
            return image;
        }
        dfs(image, sr, sc, startPixel, color, rows, cols);
        return image;
    }
    private void dfs(int[][] image, int sr, int sc, int startPixel, int color, int rows, int cols){
        // Boundary check
        if(sr < 0 || sr >= rows || sc < 0 || sc >= cols){
            return;
        }

        // Only fill cells that match original color
        if(image[sr][sc] != startPixel){
            return;
        }

        // Recolor
        image[sr][sc] = color;

        // 4 directions: up, down, left, right
        // Explore 4 directions
        dfs(image, sr - 1, sc, startPixel, color, rows, cols);
        dfs(image, sr + 1, sc, startPixel, color, rows, cols);
        dfs(image, sr, sc - 1, startPixel, color, rows, cols);
        dfs(image, sr, sc + 1, startPixel, color, rows, cols);
    }
}
//Time: O(m×n) and Space: O(m×n) (in worst case when all cells are filled).
