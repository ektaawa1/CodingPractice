package org.Week5;

/**
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 *
 * Example 2:
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 * or index number 5 where the peak element is 6.
 */
public class PeakElement {
    //Binary Search with modification
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int mid1 = left + (right - left) / 2; // to avoid overflows
            //check left side
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                right = mid - 1;
            } else if (mid < nums.length && nums[mid] < nums[mid + 1]) {
                left = mid + 1; //check right side
            } else {
                return mid;
            }
        }
        return left;
    }
}
// TC = O(log n)
