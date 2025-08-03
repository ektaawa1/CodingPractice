package top75LC.Week2;

/**
 * Given an integer array nums, move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 *
 * Note that you must do this in-place without making a copy of the array.
 * Example 1: Input: nums = [0,1,0,3,12], Output: [1,3,12,0,0]
 * Example 2: Input: nums = [0], Output: [0]
 */
public class MoveZeroes {
    // 2 pointers approach (In-place)
    public void moveZeroes(int[] nums) {
        int k = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] != 0){
                nums[k++] = nums[i];
            }
        }

        for(int i = k; i<nums.length; i++){
            nums[i] = 0;
        }
    }
}
/**
 * Dry Run: nums = [0,1,0,3,12]
 * First loop puts [1, 3, 12, ?, ?]
 * Second loop puts zeros at the end → [1, 3, 12, 0, 0]
 */

//Time: O(n)
//
//Space: O(1) (in-place)

