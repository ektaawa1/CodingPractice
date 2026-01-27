package top150LC.Week1;

//121. Best Time to Buy and Sell Stock

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and
 * choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
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
        //int minPrice = prices[0];
        //OR
        int minPrice = Integer.MAX_VALUE;

        if (prices == null || prices.length == 0) return 0;

        for(int price : prices){
            if(price < minPrice){
                minPrice = price;
            } else {
                max_profit = Math.max(max_profit, price-minPrice);
            }
        }
        return max_profit;
    }
    public int maxProfit2Pointers(int[] prices) {
        int i = 0;//buy pointer
        int j = 1;//sell pointer
        int maxProfit = 0;

        while (j < prices.length) {
            if (prices[j] > prices[i]) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            } else {
                i = j;  // move buy to lower price
                //buy pinter must always point to the lowest price seen so far before sell
            }
            j++;
        }
        return maxProfit;
    }
}

//TC = O(n)
//SC = O(1)
