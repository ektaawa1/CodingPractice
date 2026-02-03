package patternBased.prefixSum;
// 523. Continuous Subarray Sum

import java.util.HashMap;

/**
 * Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.
 * A good subarray is a subarray where:
 * its length is at least two, and
 * the sum of the elements of the subarray is a multiple of k.
 * Note that:
 * A subarray is a contiguous part of the array.
 * An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 */
public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        map1.put(0, -1);// key-> remainder, val-> index
        int sum = 0;
        int rem = 0;
        for(int i = 0; i<nums.length; i++){
            sum += nums[i];
            if(k == 0) rem = sum;
            else rem = sum % k;

            if(map1.containsKey(rem)){
                int index = map1.get(rem);
                if(i-index >= 2){
                    return true;
                }
            } else {
                map1.put(rem, i); //store earliest index only
            }
        }
        return false;
    }
}

/**
 * Example-
 * Input: nums = [23,2,4,6,7], k = 6
 * Output: true
 * Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
 *
 * Input: nums = [23,2,6,4,7], k = 13
 * Output: false
 *
 * Input: nums = [23,2,6,4,7], k = 6
 * Output: true
 * Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
 * 42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
 */
