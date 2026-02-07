package patternBased.twoPointers;

// 1. Two Sum
// https://algo.monster/liteproblems/1

import java.util.HashMap;

/**
 * Example 1: Input: nums = [2,7,11,15], target = 9, Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2: Input: nums = [3,2,4], target = 6, Output: [1,2]
 *
 * Example 3: Input: nums = [3,3], target = 6, Output: [0,1]
 */

/**
 * For Two Sum, sorting would break the mapping between numbers and their original indices, so I’d prefer a hash map.
 */

// Hashtable approach
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for(int i = 0; i<nums.length; i++){
            int diff = target - nums[i];

            if(indexMap.containsKey(diff)){
                    return new int[] {indexMap.get(diff), i};
            }
            indexMap.put(nums[i], i);
        }
        return new int[] {}; // returning an empty array if no 2 sums found
    }
}
// TC = O(n)
// SC = O(n) since HM can grow lineraly in worst case scenario
/**
 * The space complexity of the code is also O(n), since in the worst case, the code may
 * insert each element of the array nums into the map m. Therefore, the space used by the map m
 * grows linearly with the number of elements in nums.
 *
 * While the result is an array of 2 integers (O(1) space), the HashMap used for
 * lookups can store up to n elements in the worst case — making the space complexity O(n).
 */
/**
 * Brute Force- TC = O(n^2), SC = O(1)
 * for (int i = 0; i < n; i++) {
 *     for (int j = i + 1; j < n; j++) {
 *         if (nums[i] + nums[j] == target) return new int[]{i, j};
 *     }
 * }
 */
/**
 * 2 pointers approach-TC = O(nlog n), SC = O(1)
 * 1st sort the array, then apply 2 pointers
 */
