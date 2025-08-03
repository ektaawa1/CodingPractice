package top150LC.Week5;

import java.util.Arrays;

/**
 * Approach-
 * Sort the array.
 * Traverse in steps of 3 and check if arr[i] == arr[i+1] == arr[i+2].
 * If not, then the current arr[i] is your unique number.
 * Example-
 * nums = [2, 2, 3, 2]
 * After sorting → [2, 2, 2, 3]
 *
 * Now traverse in steps of 3:
 * i = 0 → nums[0], nums[1], nums[2] = 2,2,2 → okay
 * i = 3 → No next two elements → So nums[3] = 3 is the single number
 *
 * Another approach is bits counting
 */
public class FindSingleElementInArrII {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);// Sort to group triples together
        for(int i = 0; i<nums.length-2; i += 3){ //Use i += 3 to jump to the next group of three elements on each iteration.
            if(nums[i] != nums[i+1]){
                return nums[i]; // Unique number found
            }
        }
        return nums[nums.length-1]; // Unique number is at the end
        // We return nums[nums.length - 1] as a fallback.
    }
}
/**
 * Example where this is needed:
 * nums = [2, 2, 2, 3]
 * Sorted → [2, 2, 2, 3]
 * Loop handles the 2s, but doesn't touch the 3 → so we return nums[3] = 3
 */
//TC = O(nlogn)


/**
 * Example-
 * nums = [2, 2, 3, 2]
 * After sorting- nums = [2, 2, 2, 3]
 * Iterate with i += 3
 * We’ll loop while i < nums.length - 2, which means i < 2 → loop will run for i = 0.
 *
 * First iteration (i = 0):
 * nums[0] = 2, nums[1] = 2, nums[2] = 2
 * All three are equal → part of a triplet
 * Move to next group: i += 3 → i = 3
 *
 * Second iteration (i = 3):
 * Now i = 3, but nums.length - 2 = 2, so the loop stops.
 * So we return:
 * nums[nums.length - 1] = nums[3] = 3
 *
 * Final Output: 3
 */
/**
 * Another Example-
 * Input: nums = [0, 1, 0, 1, 0, 1, 99]
 * Sorted: [0, 0, 0, 1, 1, 1, 99]
 *
 * Loop:
 * i = 0: 0 == 0 == 0 ✅ → i = 3
 * i = 3: 1 == 1 == 1 ✅ → i = 6
 * i = 6: loop ends
 * Return nums[6] = 99 ✅
 */