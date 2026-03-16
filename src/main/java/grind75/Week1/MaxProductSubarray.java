package grind75.Week1;

/**
 * Q3 — Maximum Product Subarray
 * Problem: Given an integer array nums, find the contiguous subarray that has the largest product and return the product.
 * Input:  nums = [2, 3, -2, 4]
 * Output: 6
 * Explanation: [2, 3] → product = 6
 *
 * Input:  nums = [-2, 0, -1]
 * Output: 0
 * Explanation: [0] → product = 0
 *
 * Input:  nums = [-2, 3, -4]
 * Output: 24
 * Explanation: [-2, 3, -4] → product = 24
 * Constraints:
 *
 * 1 <= nums.length <= 20,000
 * -10 <= nums[i] <= 10
 */
public class MaxProductSubarray {
    public int maxProductSubarray(int[] nums){
        int maxProd = nums[0];
        int minProd = nums[0];
        int result  = nums[0];

        for(int i = 1; i < nums.length; i++){
            // multiplying by nums[i] can flip max and min
            // so consider all 3 candidates:
            int candidate1 = nums[i];              // start fresh
            int candidate2 = nums[i] * maxProd;   // extend max
            int candidate3 = nums[i] * minProd;   // extend min

            maxProd = Math.max(candidate1, Math.max(candidate2, candidate3));
            minProd = Math.min(candidate1, Math.min(candidate2, candidate3));

            result = Math.max(result, maxProd);
        }
        return result;
    }
}
//Time: O(n) — single pass
//Space: O(1) — just 3 variables
/** Note-
 * 1. Negative × Negative = Positive ← game changer
 * 2. Zero resets everything
 * 3. No fixed window size
 * So at every index you need to ask:
 * "What is the max and min product ending at this index?"
 */
