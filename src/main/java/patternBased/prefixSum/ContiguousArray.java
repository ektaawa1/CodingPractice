package patternBased.prefixSum;
// 525. Contiguous Array

import java.util.HashMap;

/**
 * Given a binary array nums,
 * return the maximum length of a contiguous subarray
 * with an equal number of 0 and 1.
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        map1.put(0,-1); //key-> sum and val-> index

        int maxLen = 0;
        int sum = 0;

        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0){
                sum += -1;
            } else {
                sum += 1;
            }

            if(map1.containsKey(sum)){
                maxLen = Math.max(maxLen, i-map1.get(sum));
            } else {
                map1.put(sum, i);
            }
        }
        return maxLen;
    }
}

/**
 * Input: nums = [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
 *
 * Input: nums = [0,1,1,1,1,1,0,0,0]
 * Output: 6
 * Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.
 *
 * Input: nums = [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 */
