package org.Week1;

//80. Remove Duplicates from Sorted Array II

/**
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 *
 * Input: nums = [0,0,1,1,1,1,2,3,3]
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 * Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */

// https://algo.monster/liteproblems/80

//2 pointers technique
public class RemoveDuplicatesArrII {
    public int removeDuplicates(int[] nums) {
        // index for placing the next unique element
        // or the second occurrence of an existing element
        int new_len = 0;
        for (int num: nums) {
            // If the current position is less than 2 (i.e., we are at the start of the array)
            // or if the current element is different than the element two positions behind
            // then consider it for inclusion in the array
            if(new_len < 2 || num != nums[new_len-2]){
                // Place the current element at the new position and increment the new position
                nums[new_len++] = num;
            }
        }
        return new_len;
    }
}

//TC = O(n)
//SC = O(1)
/**
 * The time complexity of the code is O(n), where n is the number of elements in the input list nums.
 * This is because the code consists of a single loop that goes through all elements of the list
 * exactly once.
 *
 * The space complexity of the code is O(1). No additional space is required that is dependent
 * on the input size. The variable k is used to keep track of the position in the array while
 * overwriting duplicates, but this does not scale with the size of the input.
 */

