package patternBased.stack;

import java.util.ArrayDeque;
import java.util.Deque;

//901. Online Stock Span
/**
 * Input
 * ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
 * [[], [100], [80], [60], [70], [60], [75], [85]]
 * Output
 * [null, 1, 1, 1, 2, 1, 4, 6]
 */
public class OnlineStockSpan {
    Deque<int[]> stack; //[price,span]
    public OnlineStockSpan() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int countDays = 1;
        while(!stack.isEmpty() && price >= stack.peek()[0] ){
            countDays += stack.pop()[1];
        }
        stack.push(new int[]{price, countDays});
        return countDays;
    }
}
/**
 * Time: Amortized O(1)
 * Each element:
 * Pushed once
 * Popped once
 * Total operations = O(n)
 * Space: O(n)
 */
