package top75LC.Week1;

/**
 * Best Approach: Prefix Sum — O(n)
 * First, compute the total sum of the array.
 * As you iterate through the array, maintain a running leftSum.
 * For each index i, check if:
 * leftSum == totalSum - leftSum - nums[i]
 * (This checks if the left side sum equals the right side sum)
 */

public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;
        int rightSum = 0;
        for(int n: nums){
            totalSum += n;
        }
        for(int i = 0; i<nums.length; i++){
            rightSum = totalSum- leftSum - nums[i];
            if(leftSum == rightSum){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}

/**
 * Example 1:
 * Input: nums = [1,7,3,6,5,6], Output: 3
 * Explanation:
 * The pivot index is 3.
 * Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
 * Right sum = nums[4] + nums[5] = 5 + 6 = 11
 * Example 2:
 * Input: nums = [1,2,3], Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 * Example 3:
 * Input: nums = [2,1,-1], Output: 0
 * Explanation:
 * The pivot index is 0.
 * Left sum = 0 (no elements to the left of index 0)
 * Right sum = nums[1] + nums[2] = 1 + -1 = 0
 */

/**
 * Dry Run:
 * For input: [1, 7, 3, 6, 5, 6]
 *
 * Total sum = 28
 *
 * i = 0 → left = 0, right = 27 → ❌
 *
 * i = 1 → left = 1, right = 20 → ❌
 *
 * i = 2 → left = 8, right = 19 → ❌
 *
 * i = 3 → left = 11, right = 11 → ✅ return 3
 */