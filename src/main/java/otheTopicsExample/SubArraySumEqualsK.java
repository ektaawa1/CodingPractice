package otheTopicsExample;

import java.util.HashMap;

public class SubArraySumEqualsK {
    //is the input in ascending order?
    //are elements -ve as well?
    public int subarraySum(int[] nums, int k) {
        //Brute Force Approach: TC = O(n^2), SC = O(1)
        int count = 0;
        for(int i = 0; i<nums.length; i++){
            int sum = 0;
            for(int j = i; j<nums.length; j++){
                sum = sum + nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        return count;
    }
    //Using HashMap
    public int subarraySum1(int[] nums, int k) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        map1.put(0, 1); // base case: sum 0 has 1 count

        int count = 0;
        int sum = 0;

        for(int n : nums){
            sum += n;
            if(map1.containsKey(sum-k)){
                count = count + map1.get(sum-k);
            }
            map1.put(sum, map1.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
//TC = O(n)
//SC = O(n)
//Step1: Calculate Prefix sum= 1, 1+2, 1+2+3 ==> 1,3,6
//HashMap --> Key = Prefix Sum & Val = Freq of Prefix Sum

//[1,1,1,1,1,1]  k = 3

/**
 * Dry Run:
 * Input: nums = [1, 2, 3], k = 3
 *
 * We initialize:
 * sum = 0 → running prefix sum
 * count = 0 → total subarrays found
 * map = { 0 : 1 } → base case (sum 0 seen once)
 *
 * Step 1: n = 1
 * sum = 0 + 1 = 1
 * (sum - k) = 1 - 3 = -2
 * map.containsKey(-2)? → No
 * → So, no subarray ending here sums to k.
 * Now update map:
 * map = { 0:1, 1:1 },     count = 0
 *
 * Step 2: n = 2
 * sum = 1 + 2 = 3
 * (sum - k) = 3 - 3 = 0
 * map.containsKey(0)? → Yes (value = 1)
 *
 *
 * → Means there’s 1 subarray ending here with sum = k.
 *
 * So:
 *
 * count = count + 1 = 1
 * map.put(3, 1)
 *
 *
 * Now: map = { 0:1, 1:1, 3:1 }, count = 1 (subarray [1,2])
 *
 * Step 3: n = 3
 * sum = 3 + 3 = 6
 * (sum - k) = 6 - 3 = 3
 * map.containsKey(3)? → Yes (value = 1)
 * → Means there’s 1 previous prefix sum = 3,
 * so subarray between (that index +1) to current index = sum k.
 *
 * So:
 *
 * count = count + 1 = 2
 * map.put(6, 1)
 *
 *
 * Now:
 *
 * map = { 0:1, 1:1, 3:1, 6:1 }
 *
 *
 * ✅ count = 2 (subarrays: [1,2] and [3])
 */
