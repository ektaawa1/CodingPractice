package top100Liked;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or
 * vertically neighboring. The same letter cell may not be used more than once.
 */
public class WordSearchMatrix {
    //DFS with backtracking
    public boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;
        //boolean[][] visited = new boolean[r][c];
        for(int i = 0; i<r; i++){
            for(int j = 0; j<c; j++){
                if(dfs(board, word, i, j, 0)){
                    return true;
                }
                //OR
                /**
                 * if (dfs(board, word, i, j, 0, visited)) {
                 *                                     return true;
                 *                                 }
                 */
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index){
        //base case
        if(index == word.length()){
            return true;
        }
        //boundary condition check
        if(i<0 || j<0 || i>= board.length || j>= board[0].length || board[i][j] != word.charAt(index)){
            return false;
        }
        //OR
        /**
         *  if (i < 0 || j < 0 ||
         *             i >= board.length || j >= board[0].length ||
         *             visited[i][j] ||
         *             board[i][j] != word.charAt(index)) {
         *             return false;
         *         }
         */
        char temp = board[i][j];
        board[i][j] = '#'; // mark it visited
        //OR
        //        visited[i][j] = true;

        boolean found = dfs(board, word, i, j+1, index+1) || dfs(board, word, i, j-1, index+1) || dfs(board, word, i+1, j, index+1) || dfs(board, word, i-1, j, index+1);

        board[i][j] = temp;//backtracking
        //OR
        // visited[i][j] = false;

        return found;
    }
}

// I can use a HashSet for visited, but modifying the board in place is faster and
// more memory-efficient, so it’s usually preferred.

/**
 * Time: O(m × n × 4^L)
 * m × n → starting points, L → length of the word
 * 4 → 4 directions
 * SC: O(L), Recursion stack
 * Slightly more space than in-place marking, but still very acceptable.
 * Time: O(m × n × 4^L)
 * Space: O(m × n) (visited array) + O(L) recursion stack
 */
