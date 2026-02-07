package patternBased.prefixSum;
// 930. Binary Subarrays With Sum

import java.util.HashMap;

/**
 * Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
 * A subarray is a contiguous part of the array.
 */
public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        map1.put(0,1);// prefix sum 0 occurs once

        int count = 0;
        int sum = 0;

        for(int i = 0; i<nums.length; i++){
            sum += nums[i];

            if(map1.containsKey(sum-goal)){
                count += map1.get(sum-goal);
            }
            map1.put(sum, map1.getOrDefault(sum,0)+1);
        }
        return count;
    }
}

/**
 * Input: nums = [1,0,1,0,1], goal = 2
 * Output: 4
 * Explanation: The 4 subarrays are bolded and underlined below:
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 *
 * Input: nums = [0,0,0,0,0], goal = 0
 * Output: 15
 */