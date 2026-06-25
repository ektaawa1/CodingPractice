package patternBased.dynamicProg;

import java.util.Arrays;

/**
 * Problem: Given an array of coin denominations and a target amount,
 * find the minimum number of coins needed to make that amount.
 * If it's not possible, return -1.
 * Example: Trace on [1,2,5], amount=11
 * dp[0] = 0        // base case, need 0 coins to make 0
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
 * dp[11] = 3       // 5+5+1
 */
//Can I reach the TARGET amount by adding coin-by-coin? What's the MINIMUM coins needed?
public class CoinChange {
    //brute force approach
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int result = bruteForce(coins, amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int bruteForce(int[] coins, int amount) {
        // base cases
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int subResult = bruteForce(coins, amount - coin);//11-1=10---> 10-1=9
            if (subResult != Integer.MAX_VALUE) {
                minCoins = Math.min(minCoins, 1 + subResult);
            }
        }
        return minCoins;
    }
// Time: O(amount ^ coins.length) → exponential
// Space: O(amount) → recursion stack
    //Using bottom-up DP approach
    public int coinChangeOptimized(int[] coins, int amount){
        if(coins == null || coins.length == 0){
            return -1;
        }
        // Fill with amount+1 as "infinity" (impossible value)
        //build a min coins needed lookup array
        //where i is the amount and arr[i] is the min coins needed to build amount i
        int[] arr = new int[amount + 1];// amount = 11, so dp = new int[12] as we have to find amounts from 0 to 11= 12 elements
        Arrays.fill(arr, amount + 1);// means "impossible" / infinity
        //index: [0,  1,  2,  3,  4,  5,  6,  7,  8,  9,  10, 11]
        //value: [12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12]

        arr[0] = 0; //base case: amount 0 needs 0 coins
        //index: [0,  1,  2,  3,  4,  5,  6,  7,  8,  9,  10, 11]
        //value: [0,  12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12]

        //I build this answer for every step from 1 to my target amount.
        // By the time I reach the target, I have the optimal answer.
        for(int i = 1; i <= amount; i++){
            for(int coin : coins){
                if(coin <= i){
                    arr[i] = Math.min(arr[i], 1+ arr[i - coin]);
                }
            }
        }

        return arr[amount] > amount ? -1 : arr[amount];
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

/**
 * "The simplest approach (brute force)—
 *  at amount 11, try every coin:
 *
 *  Use ₹1 → now solve for amount 10
 *  Use ₹2 → now solve for amount 9
 *  Use ₹5 → now solve for amount 6
 *
 *  For each of those, try every coin again.
 *  Keep going until amount = 0 (found solution)
 *  or amount < 0 (invalid path).
 *
 *  Take the minimum across all valid paths."
 */
