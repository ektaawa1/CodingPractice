package org.Week4;

/**
 * Given an array of integers nums sorted in non-decreasing order,
 * find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 */
//Using Binary Search for O(log n)
public class FirstLastIndexInArray {
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums, target, true);   // Search for first occurrence
        int last = binarySearch(nums, target, false);   // Search for last occurrence
        return new int[]{first, last};
    }

    private int binarySearch(int[] nums, int target, boolean findFirst) {
        int left = 0, right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                if (findFirst) {
                    right = mid - 1;  // Continue search on the left
                } else {
                    left = mid + 1;   // Continue search on the right
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {  // nums[mid] > target
                right = mid - 1;
            }
        }

        return result;
    }
}

/**
 * Why Two Pointers Isn't Ideal:
 * Two pointers = linear scan, which takes O(n) in the worst case (e.g., all elements are the target).
 * But since the array is sorted, we can exploit that and use binary search to find:
 * The first occurrence of the target
 * The last occurrence of the target
 */
