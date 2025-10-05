package top150LC.Week5;
// 918. Maximum Sum Circular Subarray

/**
 * Given a circular integer array nums of length n, return the maximum possible sum of a
 * non-empty subarray of nums.
 */
public class MaxSubArraySumCircular {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int currMax = 0;
        int currMin = 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        for(int n : nums){
            currMax = Math.max(n, currMax + n); // Kadane for max subarray
            currMin = Math.min(n, currMin + n); // Kadane for min subarray

            maxSum = Math.max(currMax, maxSum); // Kadane for max subarray
            minSum = Math.min(currMin, minSum); // Kadane for min subarray

            totalSum = totalSum + n;
        }

        if(maxSum < 0){ //for negative sum
            return maxSum;
        }
        return Math.max(maxSum, totalSum-minSum);
    }
}

//Time: O(n) (single pass)
//Space: O(1) (constant extra memory)

/**
 * Key Idea:
 * There are two possibilities:
 * Normal Kadane → max subarray without wrapping.
 * Wraparound case → totalSum - minSubarraySum.
 * Here, we remove the smallest subarray to maximize the sum of the rest.
 * But caution: If all numbers are negative, the wraparound case would give 0,
 * which is invalid. So in that case, just return the normal Kadane result.
 */
