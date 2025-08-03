package org.Week1;

// 122. Best Time to Buy and Sell Stock II
// https://algo.monster/liteproblems/122
/**
 * In mathematical terms, if prices[i] < prices[i + 1], then you would want to buy on day i
 * and sell on day i+1 to gain prices[i + 1] - prices[i] profit. If you repeat this process
 * for every increase in the stock price, the sum of all these individual profits will give you
 * the maximum profit that can be achieved.
 */

/**
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 * Example 2:
 *
 * Input: prices = [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Total profit is 4.
 * Example 3:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: There is no way to make a positive profit, so we never buy the stock to
 * achieve the maximum profit of 0.
 */
// Greedy Algo
public class SellStocksII {
    public int maxProfit(int[] prices) {
        int total_gain = 0;
        for(int i = 1; i<prices.length; i++){
            int daily_gain = Math.max(0,prices[i]-prices[i-1]);

            total_gain += daily_gain;
        }
        return total_gain;
    }
}

//TC = O(n)
//SC = O(1)

/**
 * Explanation-
 *
 * Walk through the prices array:
 *
 * Day 0 to Day 1: The price goes from 7 to 1. No profit is possible because the price drops. Therefore, the profit is max(0, 1 - 7) = 0.
 * Day 1 to Day 2: The price goes from 1 to 5. The profit is max(0, 5 - 1) = 4. You buy at 1 and sell at 5.
 * Day 2 to Day 3: The price goes from 5 to 3. No profit is possible because the price drops. The profit is max(0, 3 - 5) = 0.
 * Day 3 to Day 4: The price goes from 3 to 6. The profit is max(0, 6 - 3) = 3. You buy at 3 and sell at 6.
 * Day 4 to Day 5: The price goes from 6 to 4. No profit, as the price drops. The profit is max(0, 4 - 6) = 0.
 * Now, you sum up all the profits from the transactions where it was profitable to buy and sell:
 *
 * Profit = 0 + 4 + 0 + 3 + 0 = 7
 */
