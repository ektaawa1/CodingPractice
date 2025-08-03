package top75LC.Week2;

import java.util.Arrays;
import java.util.HashMap;

public class MaxNoKSumPairs {
    //Use Hashmap as 2 pointers approach will need sorting so TC will be O(nlogn)
    //But with Hashmap, TC will be O(n), SC = O(n)
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map1 = new HashMap<>();
        int count = 0;
        for(int n: nums){
            int diff = k-n;
            if(map1.getOrDefault(diff,0)>0){
                count++;
                map1.put(diff, map1.get(diff)-1);
            }else{
                map1.put(n, map1.getOrDefault(n, 0) + 1);
            }
        }
        return count;
    }
    // Use 2 pointers approach where TC = O(nlog n), SC = O(1)
    public int maxOperations1(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length-1;
        int count = 0;
        while(l<r) {
            int sum = nums[l]+ nums[r];
            if(sum == k){
                count++;
                l++;
                r--;
            }else if(sum > k){
                r--;
            }else {
                l++;
            }
        }
        return count;
    }
}
// Input: nums = [3,1,3,4,3,1,3], k = 6
//We’ll track:
//map = {} to store the needed complements
//count = 0 to count the valid pairs

/**
 * Note-
 * map.getOrDefault(complement, 0)
 * You're saying:
 * "Check if complement exists in the map.
 * If yes, return its value.
 * If no, treat its count as 0."
 * This avoids a NullPointerException and lets you safely use the value for comparison or arithmetic.
 */
/**
 * Step-by-step Dry Run:
 * Step 1: num = 3
 * Need: 6 - 3 = 3
 * 3 not in map → record need for 3
 * map = {3:1}
 * Step 2: num = 1
 * Need: 6 - 1 = 5
 * 5 not in map → record need for 1
 * map = {3:1, 5:1}
 * Step 3: num = 3
 * Need: 6 - 3 = 3
 * map[3] == 1 → valid pair (3,3)!
 * Update: map[3] = 0, count = 1
 * map = {3:0, 5:1}
 * Step 4: num = 4
 * Need: 6 - 4 = 2
 * 2 not in map → record need for 4
 * map = {3:0, 5:1, 2:1}
 * Step 5: num = 3
 * Need: 6 - 3 = 3
 * map[3] == 0 → can’t pair, record new need for 3
 * map = {3:1, 5:1, 2:1}
 * Step 6: num = 1
 * Need: 6 - 1 = 5
 * map[5] == 1 → valid pair (1,5)!
 * Update: map[5] = 0, count = 2
 * map = {3:1, 5:0, 2:1}
 * Step 7: num = 3
 * Need: 6 - 3 = 3
 * map[3] == 1 → valid pair (3,3)!
 * Update: map[3] = 0, count = 3
 * map = {3:0, 5:0, 2:1}
 */
