package top150LC.Week8;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows){ // for this case- Input: s = "A", numRows = 1, Output: "A"
            return s;
        }
        if (s == null || s.isEmpty()){
            return s;
        }
        StringBuilder stb[] = new StringBuilder[numRows];
        StringBuilder result = new StringBuilder();
        for(int i = 0; i<numRows; i++){
            stb[i] = new StringBuilder();
        }

        int currRow = 0;
        int dir = -1; //1 for down & -1 for up direction

        for(char c: s.toCharArray()){
            if(currRow == 0 || currRow == numRows-1){ // flip direction up or down
                dir = - dir;
            }
            stb[currRow].append(c);
            currRow += dir;
        }
        //Merge All rows
        for(StringBuilder row: stb){
            result.append(row);
        }
        return result.toString();
    }
}
/** Initial String Builder-
 [[]
 []
 []]

 Dry Run (for "PAYPALISHIRING", numRows = 3)
 Start: row = 0, goingDown = false
 Place 'P' → row 0 → flip dir ↓ → row = 1
 Place 'A' → row 1 → row = 2
 Place 'Y' → row 2 → flip dir ↑ → row = 1
 Place 'P' → row 1 → row = 0
 Place 'A' → row 0 → flip dir ↓ → row = 1
 Continue… (row 0->1->2->1->0->1->2.... and so on. )

 Finally-
 [
 [PAHN]
 [APLSIIG]
 [YIR]
 ]
 */

// TC is O(n)
// SC is O(n)
