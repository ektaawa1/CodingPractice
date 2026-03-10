package patternBased.graph.dfsBfs;
// 1926. Nearest Exit from Entrance in Maze

import java.util.LinkedList;
import java.util.Queue;

/**
 * Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
 * Output: 1
 * Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
 * Output: 2
 * Input: maze = [[".","+"]], entrance = [0,0]
 * Output: -1
 */
public class NearestExitFromEntranceInMaze {
    //This is single-source BFS.
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1]});

        maze[entrance[0]][entrance[1]] = '+'; // mark visited

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        int steps = 0;

        while(!queue.isEmpty()) {

            int size = queue.size();
            steps++;

            for(int i = 0; i < size; i++) {

                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                for(int[] dir : directions) {

                    int newRow = r + dir[0];
                    int newCol = c + dir[1];

                    if(newRow >= 0 && newRow < rows &&
                            newCol >= 0 && newCol < cols &&
                            maze[newRow][newCol] == '.') {

                        // if boundary and not entrance
                        if(newRow == 0 || newRow == rows - 1 ||
                                newCol == 0 || newCol == cols - 1) {
                            return steps;
                        }

                        maze[newRow][newCol] = '+'; // mark visited
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }

        return -1;
    }
}
/**
 Shortest path from ONE source to nearest boundary exit.
 We want:
 Distance FROM entrance → TO nearest boundary. So only entrance goes into queue.
 Ask before coding:
 Am I expanding FROM many sources?
 OR
 Am I expanding FROM one starting point?
 That determines queue initialization.

 If problem says:
 Distance FROM something → single source
 If problem says:
 Distance TO nearest something → multi-source
 */
/**
 Steps:
 Add entrance to queue.
 Mark entrance visited.
 BFS level by level.
 If we reach a boundary "." (not entrance) → return steps. */
