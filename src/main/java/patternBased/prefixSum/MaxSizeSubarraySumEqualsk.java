package patternBased.prefixSum;
// 325. Maximum Size Subarray Sum Equals k

import java.util.HashMap;

/**
 * Given an integer array nums and an integer k,
 * return the maximum length of a subarray that sums to k. If there is not one, return 0 instead.
 */
public class MaxSizeSubarraySumEqualsk {
    public int maxSubArrayLen(int[] nums, int k) {
        //negative input
        //return maxLen
        HashMap<Integer, Integer> map1 = new HashMap<>();
        map1.put(0,-1);
        int sum = 0;
        int maxLen = 0;

        for(int i = 0; i<nums.length; i++){
            sum += nums[i];//1

            if(map1.containsKey(sum-k)){
                maxLen = Math.max(maxLen, i-map1.get(sum-k));
            }
            if(!map1.containsKey(sum)){
                map1.put(sum, i);//1,0
            }

        }
        return maxLen;
    }
}
/**
 * Input: nums = [1,-1,5,-2,3], k = 3
 * Output: 4
 * Explanation: The subarray [1, -1, 5, -2] sums to 3 and is the longest.
 *
 * Input: nums = [-2,-1,2,1], k = 1
 * Output: 2
 * Explanation: The subarray [-1, 2] sums to 1 and is the longest.
 */
