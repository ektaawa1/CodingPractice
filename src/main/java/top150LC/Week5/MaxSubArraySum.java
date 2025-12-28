package top150LC.Week5;

/**
 * Given an integer array nums, find the subarray with the largest sum, and return its sum.
 * Example 1:
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 */
public class MaxSubArraySum {
    //Kadane’s algorithm works in linear time O(n)
    public int maxSubArray(int[] nums) {
        int maxSubArrSum = nums[0];
        int currSum = 0;

        for(int n: nums){
            if(currSum < 0){//if the sum is -ve i.e., -10 or -3, etc.
                currSum = 0;
            }
            currSum += n;
            maxSubArrSum = Math.max(maxSubArrSum, currSum);
        }
        return maxSubArrSum;
    }
}
/**
 * Sliding window is great when the window size is fixed or condition-based, e.g., max sum of subarray of size k, or sum ≤ target.
 *
 * But here, the subarray size is not fixed — and the only rule is: maximize the sum.
 * Kadane’s takes care of that by “resetting the window” when needed (start new subarray if sum < 0).
 */

/**
 * Brute Force (your brain's natural first step)
 * Try all possible subarrays → O(n²) time
 * Too Slow
 */

//Explanation-
/**
 * The idea is to scan the array from left to right while keeping track of two things:
 * currSum: the sum of the current subarray.
 * maxSum: the best (maximum) sum we’ve seen so far.
 *
 * At each element:
 * I add the current element to currSum.
 * If currSum becomes negative, I reset it to 0 because a negative sum won’t help us get a bigger result later.
 * At every step, I update maxSum if currSum is higher than maxSum.
 * This way, I’m always looking for the best subarray ending at the current index.”
 */
