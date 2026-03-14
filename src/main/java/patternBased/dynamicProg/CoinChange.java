package patternBased.dynamicProg;

import java.util.Arrays;

/**
 * Problem: Given an array of coin denominations and a target amount,
 * find the minimum number of coins needed to make that amount.
 * If it's not possible, return -1.
 * Example: Trace on [1,2,5], amount=11
 * dp[0] = 0        // base case, 0 coins to make 0
 * dp[1] = 1        // 1
 * dp[2] = 1        // 2
 * dp[3] = 2        // 2+1
 * dp[4] = 2        // 2+2
 * dp[5] = 1        // 5
 * dp[6] = 2        // 5+1
 * dp[7] = 2        // 5+2
 * dp[8] = 3        // 5+2+1
 * dp[9] = 3        // 5+2+2
 * dp[10] = 2       // 5+5
 * dp[11] = 3       // 5+5+1 ✅
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount){
        // Fill with amount+1 as "infinity" (impossible value)
        int[] dp = new int[amount + 1];// amount = 11, so dp = new int[12]
        Arrays.fill(dp, amount + 1);// means "impossible" / infinity
        //index: [0,  1,  2,  3,  4,  5,  6,  7,  8,  9,  10, 11]
        //value: [12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12]

        dp[0] = 0; // base case
        //index: [0,  1,  2,  3,  4,  5,  6,  7,  8,  9,  10, 11]
        //value: [0,  12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12]

        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if(coin <= i){
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
        //## Why 12 specifically as "infinity"?
        //Because the **worst case** is using all 1-cent coins:
        //amount 11 using coin 1 → needs exactly 11 coins
    }
}
//Time: O(amount × coins.length)
//Space: O(amount)
/**
 * Input:  coins = [1, 5, 6, 9], amount = 11
 * Output: 2
 * Explanation: 5 + 6 = 11 (2 coins)
 *
 * Input:  coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 5 + 5 + 1 = 11 (3 coins)
 *
 * Input:  coins = [2], amount = 3
 * Output: -1 (not possible)
 */

/**
 * Explanation-
 * Coin Change — 2 Variables Don't Work Because:
 * At every amount, you look back by each coin's value — the lookback is variable.
 * dp[11] needs → dp[11-1]=dp[10], dp[11-2]=dp[9], dp[11-5]=dp[6]
 * dp[10] needs → dp[10-1]=dp[9],  dp[10-2]=dp[8], dp[10-5]=dp[5]
 * You need all previous answers still available — not just the last 2.
 *
 ********************* Simple Rule to Remember*******************
 * Lookback is FIXED (always i-1, i-2)
 * → Use variables (O(1) space)
 *
 * Lookback is VARIABLE (depends on input)
 * → Use full DP array (O(n) space)
 */
