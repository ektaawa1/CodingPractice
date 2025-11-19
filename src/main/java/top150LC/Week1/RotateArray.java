package top150LC.Week1;

// 189. Rotate Array

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 */

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int input_len = nums.length;
        // if k is greater than length of array
        k = k % input_len; // k%= nums.length

        //reverse the last k elements
        swap_elements(input_len-k, input_len-1, nums);

        //reverse the first nums.length-k elements
        swap_elements(0, input_len-k-1, nums);

        //revere the whole array
        swap_elements(0, input_len-1, nums);
    }

    private void swap_elements(int i, int j, int[] nums) {
        while (i<j){
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }
}

/**
 * Explanation-
 *
 *  Using Reversal Algo- First, reverse the last K elements
 *  Second, reverse the rst n-k elements of the array
 *  Third, reverse the complete array.
 *  Eg- Input- nums = [1,2,3,4,5,6,7], k = 3
 *  Step1- [1,2,3,4,7,6,5] (Reverse elements 7,6,5)
 *  Step2- [4,3,2,1,7,6,5] (Reverse elements 1,2,3,4)
 *  Step3- [5,6,7,1,2,3,4] (Reverse the whole array) ===> Output
 *  Time Complexity = O(n) ; Space Complexity = O(1)
 */
