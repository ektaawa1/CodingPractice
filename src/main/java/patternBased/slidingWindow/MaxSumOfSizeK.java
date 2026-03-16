package patternBased.slidingWindow;

/**
 * Problem: Given an array of integers and a number k, find the maximum sum of any contiguous
 * subarray of size exactly K.
 * Input:  nums = [2, 1, 5, 1, 3, 2], k = 3
 * Output: 9
 * Explanation: [5, 1, 3] → sum = 9
 *
 * Input:  nums = [2, 3, 4, 1, 5], k = 2
 * Output: 7
 * Explanation: [3, 4] → sum = 7
 * Constraints:
 *
 * 1 <= k <= nums.length <= 100,000
 * -10,000 <= nums[i] <= 10,000
 */
public class MaxSumOfSizeK {
    public int maxSumSubarrayOfSizeK(int nums[], int k){
        int windowSum = 0;
        int maxSum = 0;

// Step 1: first window
        for(int i = 0; i < k; i++){
            windowSum += nums[i];
        }
        maxSum = windowSum;

// Step 2: slide the window
        for(int right = k; right < nums.length; right++){
            windowSum += nums[right];         // add incoming
            windowSum -= nums[right - k];     // remove outgoing
            maxSum = Math.max(maxSum, windowSum); // update max
        }
        return maxSum;
    }
}
//Time: O(n) — one pass after first window
//Space: O(1) — no extra data structure needed
