package patternBased.dfsBfs;
// 463. Island Perimeter

/**
 * Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
 * Output: 16
 * Input: grid = [[1]]
 * Output: 4
 * Input: grid = [[1,0]]
 * Output: 4
 */
public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int perimeter = 0;

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == 1){
                    perimeter += 4;//as each cell has 4 boundaries

                    //Now check in all the 4 directions of that cell
                    // check top
                    if (i > 0 && grid[i - 1][j] == 1)
                        perimeter--;

                    // check bottom
                    if (i < rows - 1 && grid[i + 1][j] == 1)
                        perimeter--;
                    if (j > 0 && grid[i][j - 1] == 1)
                        perimeter--;

                    // check right
                    if (j < cols - 1 && grid[i][j + 1] == 1)
                        perimeter--;
                }
            }
        }//outer for loop
        return perimeter;
    }
}
//Time: O(rows × cols)
//Space: O(1)

/**
 No DFS required.
 No visited array.
 Just one pass.
 For Eg-
 input is    1 1
 If we count separately:
 Cell 1 → 4 sides
 Cell 2 → 4 sides
 but in actual one side is common b/w them which we don't have to count
 So the answer should be 6 and not 8

 */
