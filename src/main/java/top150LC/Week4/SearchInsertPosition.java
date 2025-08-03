package org.Week4;

// Using Binary Search Algo to solve in
// O(log n) time complexity as per the question requirement
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int l = 0;
        int r = nums.length -1;
        while (l<=r) {
            int mid = (l+r) / 2;// This is unsafe to use as will fail with larger integers
            // Use this-
            //int mid = left + (right - left) / 2;  → Classic safe version
            // int mid = (left + right) >>> 1; → Bitwise safe and sometimes faster
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid]<target){
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return l;
    }
}

/**
 * Given a sorted array of distinct integers and a target value, return the index
 * if the target is found. If not, return the index where it would be if it were
 * inserted in order.
 *
 * Example 1:
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 *
 * Example 2:
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 *
 * Example 3:
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 */

//Note: Why are we returning l if number not found??
/**
 * Example
 * nums = [1, 3, 5, 6], target = 2
 * Binary search trace:
 * l=0, r=3 → mid=1 → nums[1]=3 > 2 → r=0
 * l=0, r=0 → mid=0 → nums[0]=1 < 2 → l=1
 * Now l=1, r=0 → Exit loop.
 * We return l = 1 → which is the correct insert position for 2.
 */

// >>> is the unsigned right shift operator in Java.
//
//It shifts bits to the right and fills leftmost bits with zeros, regardless of the sign (unlike >>, which maintains the sign bit).
//
//Used here, it simply divides by 2 safely, without overflow.
