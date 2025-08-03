package org.Week2;

// 12. Integer to Roman

/**
 * Example 1: Input: num = 3749, Output: "MMMDCCXLIX"
 * Explanation:
 * 3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
 *  700 = DCC as 500 (D) + 100 (C) + 100 (C)
 *   40 = XL as 10 (X) less of 50 (L)
 *    9 = IX as 1 (I) less of 10 (X)
 * Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
 *
 * Example 2: Input: num = 58, Output: "LVIII"
 * Explanation:
 * 50 = L
 *  8 = VIII
 *
 * Example 3: Input: num = 1994, Output: "MCMXCIV"
 * Explanation:
 * 1000 = M
 *  900 = CM
 *   90 = XC
 *    4 = IV
 */

//greedy algorithm
public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] values =    {1000, 900, 500, 400, 100, 90,  50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                sb.append(symbols[i]);// String Builder appends without creating new objects
            }
        }

        return sb.toString();
    }
}
//TC
//O(1) — Constant time.
//
//Why? Because the number range is fixed: 1 to 3999, so the loop will run at most 13 times.


//If they ask "Why Greedy?":
//
//"Because at each step, I subtract the largest possible Roman value to build the numeral,
// ensuring the shortest valid Roman numeral — this is the greedy choice."