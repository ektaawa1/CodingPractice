package patternBased.stack;
// System Monitoring — Nearest Greater Load

import java.util.Stack;

/**
 * A data center records server load every minute.
 * For each minute, find the next minute to the right with higher load.
 * If none exists, return -1 for that position.
 * Example-
 * loads = [4, 5, 2, 10, 8]
 * output is: [5, 10, 10, -1, -1]
 */
public class SystemMonitoringLoad {
    public int[] nextGreaterElement(int[] loads) {
        if (loads == null || loads.length == 0) {
            return new int[0];
        }

        int n = loads.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            // Remove all elements smaller or equal to current
            while (!stack.isEmpty() && stack.peek() <= loads[i]) {
                stack.pop();
            }

            // If stack empty → no greater element
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }

            // Push current element
            stack.push(loads[i]);
        }

        return result;
    }

}
