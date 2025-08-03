package top150LC.Week6;

import java.util.HashSet;

/**
 * To uniquely identify each sub-box, we use this formula:
 * int boxIndex = (i / 3) * 3 + (j / 3);
 * (i / 3) gives row group: 0 for rows 0–2, 1 for 3–5, 2 for 6–8.
 * (j / 3) gives column group: 0, 1, 2
 * Multiply row group by 3 and add column group → gives a unique index between 0 and 8.
 */

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // rowSet → [ null, null, null, null, null, null, null, null, null ]
        HashSet<Character> rowSet[] = new HashSet[9]; //declares an array of 9 HashSets.
        HashSet<Character> columnSet[] = new HashSet[9];
        HashSet<Character> boxSet[] = new HashSet[9];

        //initialize the sets from 0-8
        for(int i = 0; i < 9; i++){
            //rowSet → [ Set_0, Set_1, Set_2, Set_3, Set_4, Set_5, Set_6, Set_7, Set_8 ]
            // rowSet → [ {}, {}, {}, {}, {}, {}, {}, {}, {} ]
            // rowSet[0] tracks digits in row 0
            rowSet[i] = new HashSet<>();
            columnSet[i] = new HashSet<>();
            boxSet[i] = new HashSet<>();
        }

        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                char ch = board[i][j];
                if(ch == '.'){
                    continue;
                }
                int boxIndex = (i/3)*3 + (j/3); // calculate which box this cell belongs to
                if(rowSet[i].contains(ch) || columnSet[j].contains(ch) || boxSet[boxIndex].contains(ch)){
                    return false;
                }
                //add values to the set
                rowSet[i].add(ch);
                columnSet[j].add(ch);
                boxSet[boxIndex].add(ch);
            }
        }
        return true;
    }
}
//Imagine each row of Sudoku having its own clipboard (HashSet) to keep track
// of what numbers are already written there. The array is just a cabinet holding these 9 clipboards
// — one for each row.
/**
 * We're checking whether a given 9×9 Sudoku board is valid. That means:
 * Each row must have unique digits (1–9),
 * Each column must have unique digits (1–9),
 * Each of the 9 sub-boxes (3×3) must also have unique digits.
 *
 * We use three arrays of HashSet:
 * rowSet[9] to track numbers in each row,
 * columnSet[9] to track numbers in each column,
 * boxSet[9] to track numbers in each 3x3 sub-box.
 * Each HashSet stores the characters (digits) that we’ve already seen in that unit (row/col/box).
 */

//TC & SC-
//Each lookup/add in a HashSet is O(1) average time.
//
//So TC = O(1)
//We create: 9 sets for rows, 9 sets for columns, 9 sets for boxes.
//Each set stores up to 9 digits → total of at most 81 (9*9) entries across all sets.
//So SC = O(1) (constant space)
