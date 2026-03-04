package patternBased.dfsBfs;

/**
 * This is a Multi-Source BFS problem.
 * Because:
 * You need minimum distance.
 * BFS guarantees shortest path in unweighted graph
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Add all gates (0s) into queue first.
 * Run BFS.
 * Expand outward layer by layer.
 * Fill distances.
 */
public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {

        if(rooms == null || rooms.length == 0)
            return;

        int rows = rooms.length;
        int cols = rooms[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Add all gates
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(rooms[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // Step 2: BFS
        while(!queue.isEmpty()){

            int[] cell = queue.poll();

            for(int[] dir : directions){
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];

                if(newRow >= 0 && newRow < rows &&
                        newCol >= 0 && newCol < cols &&
                        rooms[newRow][newCol] == Integer.MAX_VALUE){

                    rooms[newRow][newCol] =
                            rooms[cell[0]][cell[1]] + 1;

                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }

}
/**
 You are given an m x n 2D grid rooms initialized with these values:
 -1 → Wall
 0 → Gate
 INF → Empty room
 (INF = 2147483647)
 * Fill each empty room with the distance to its nearest gate.
 * If unreachable, leave it as INF.
 * Distance is the number of steps moving up, down, left, or right.
 * Input = [
 *  [INF, -1,  0,  INF],
 *  [INF, INF, INF, -1],
 *  [INF, -1,  INF, -1],
 *  [ 0,  -1,  INF, INF]
 * ]
 * Output =
 * [
 *  [ 3, -1,  0,  1],
 *  [ 2,  2,  1, -1],
 *  [ 1, -1,  2, -1],
 *  [ 0, -1,  3,  4]
 * ]
 */
