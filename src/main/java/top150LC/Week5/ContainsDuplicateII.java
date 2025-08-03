package org.Week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> numsMap = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            if(numsMap.containsKey(nums[i])){
                if(i-numsMap.get(nums[i]) <= k){
                    return true;
                }
            }
            // Always update the latest index for the number
            numsMap.put(nums[i], i);
        }
        return false;
    }
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (window.contains(nums[i])) {
                return true;
            }

            window.add(nums[i]);

            // Maintain window size of at most k
            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }

        return false;
    }
}
/**
 * Using HashMap- Tracks latest index of elements
 * TC = O(n), SC = O(n)
 *
 * Using HashSet + Window- Slightly more space efficient if k ≪ n
 * TC = O(n), SC = O(k)
 */
//Explanation- HashSet
/**
 * How It Works:
 * You're creating a sliding window of size k using a HashSet.
 * At every step:
 * You check if the current number exists in the set — if yes, it means a duplicate was found within k range.
 * You add the number to the set.
 * If the window becomes larger than k, you remove the oldest element (i.e., the one k positions behind).
 * This way, you're only keeping the last k elements in memory and checking for duplicates within that window.
 */
/**
 * I'm maintaining a HashSet of size at most k to simulate a sliding window over the last k elements.
 * At each step, I check whether the current element is already in the window — if yes,
 * we've found a duplicate within the allowed range. Otherwise, I add it to the set.
 * To ensure the window doesn't exceed k, I remove the element that's k steps behind.
 * This keeps both time and space complexity at O(n).
 */
/**
 * Dry Run-
 * | i | nums\[i] | Set (window) | Action                           |
 * | - | -------- | ------------ | -------------------------------- |
 * | 0 | 1        | `{}`         | Not in set, add 1                |
 * | 1 | 2        | `{1}`        | Not in set, add 2                |
 * | 2 | 3        | `{1,2}`      | Not in set, add 3                |
 * | 3 | 1        | `{1,2,3}`    | **1 is in set → return true**    |
 */