package patternBased.slidingWindow;

/**
 * You are given an array where each element represents the CPU load of a server at each minute.
 * Your task is to find the maximum average load of any contiguous subarray of size K.
 * Return the maximum average as a double.
 *
 * Input: loads = [1, 12, -5, -6, 50, 3], k = 4
 * Output: 12.75
 * Input: loads = [5], k = 1
 * Output: 5.0
 * Constraints
 * 1 ≤ k ≤ loads.length ≤ 100,000
 * Values may be negative
 * Must be efficient
 */
public class ServerLoadAnalyzer {
    public double findMaxAverage(int[] loads, int k) {
        if (loads == null || loads.length == 0 || k > loads.length) return 0.0;

        int windowSum = 0;
        // first window
        for (int i = 0; i < k; i++) {
            windowSum += loads[i];
        }
        int maxSum = windowSum;

        // slide the window
        for (int right = k; right < loads.length; right++) {
            windowSum += loads[right] - loads[right - k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return (double) maxSum / k;
    }
}

//Note:
//Negative numbers do NOT break sliding window for fixed size.
// Sliding window fails with negatives only when we rely on monotonic behavior (e.g., sum ≥ target problems).
/**
 * Sliding window can still work with negative numbers if your window is constrained by size or counts,
 * not by sum comparison.
 * Examples-
 * Fixed-size window (like “average of k elements”) [LC 643. Maximum Average Subarray I with negative numbers works perfectly]
 * Counting / constraints (not sum comparison)- [Examples: “at most K zeros”, “at most 2 distinct chars”]
 */

//Time → O(n) (single pass)
//Space → O(1) (only 2 ints)

/**
 * Scenarios where sliding window fails:
 * Variable-size window with a threshold sum AND array has negative numbers
 * Example: “Find the longest subarray with sum ≤ k” when nums may have negative numbers
 * You can’t just shrink when sum > k, because adding a negative may decrease the sum and make it valid again
 *
 * Sliding window works with negatives if the window validity is determined by
 * size, counts, or monotonic constraints, not by a threshold sum that can decrease unpredictably.
 */