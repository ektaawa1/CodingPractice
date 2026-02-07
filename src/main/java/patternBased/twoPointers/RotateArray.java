package patternBased.twoPointers;

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

    public void rotateBetter(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return;
        }
        int len = nums.length;
        if(k> len){
            k = k % len;
        }
        //1st reverse the whole array
        reverseArray(nums, 0, len-1); //[7,6,5,4,3,2,1]
        //2nd reverse the 1st k elements
        reverseArray(nums, 0, k-1); //[5,6,7,4,3,2,1]
        //3rd reverse the n-k elements
        reverseArray(nums, k, len-1); //[5,6,7,1,2,3,4]
    }
    private void reverseArray(int[] nums, int i, int j){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}

/**
 *  Time Complexity = O(n) ; Space Complexity = O(1)
 */

/**
 * Right rotation (what you already know)
 * Steps:
 * Reverse whole array
 * Reverse first k
 * Reverse remaining n - k
 * reverse(nums, 0, n - 1);
 * reverse(nums, 0, k - 1);
 * reverse(nums, k, n - 1);
 */

/**
 * Left rotation — what changes? Only the order of reversals
 *
 * Steps for LEFT rotation by k:
 * Reverse first k elements
 * Reverse remaining n - k elements
 * Reverse the whole array
 * reverse(nums, 0, k - 1);
 * reverse(nums, k, n - 1);
 * reverse(nums, 0, n - 1);
 */
