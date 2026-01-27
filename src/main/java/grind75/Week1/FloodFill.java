package grind75.Week1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an image represented by an m x n grid of integers image, where image[i][j]
 * represents the pixel value of the image. You are also given three integers sr, sc, and color.
 * Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].
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
        int currColor = image[sr][sc];
        if(currColor == color) return image; // nothing to change
        dfs(image, sr, sc, currColor, color);
        return image;
    }
    private void dfs(int[][] image, int r, int c, int currColor, int newColor){
        if(r < 0 || c < 0 || r >=image.length || c >= image[0].length) return; //exit the function
        if(image[r][c] != currColor) return; //exploring neighbors //exit the function

        image[r][c] = newColor;

        // 4 directions: up, down, left, right
        dfs(image, r+1, c, currColor, newColor);
        dfs(image, r-1, c, currColor, newColor);
        dfs(image, r, c+1, currColor, newColor);
        dfs(image, r, c-1, currColor, newColor);
    }
}
//Time: O(m×n) and Space: O(m×n) (in worst case when all cells are filled).
