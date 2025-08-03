package org.Week1;

//121. Best Time to Buy and Sell Stock

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * Example 2:
 *
 * Input: prices = [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transactions are done and the max profit = 0.
 */

// One pass algorithm (Greedy Algorithms)
    // https://algo.monster/liteproblems/121
public class SellStocks {
    public int maxProfit(int[] prices) {
        int max_profit = 0;
        int min_buy_price = prices[0];

        for(int price : prices){
            max_profit = Math.max(max_profit, price-min_buy_price);

            //update the min price if the lower price is found
            min_buy_price = Math.min(min_buy_price, price);
        }
        return max_profit;
    }
}

//TC = O(n)
//SC = O(1)
