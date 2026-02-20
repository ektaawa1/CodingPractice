package patternBased.binarySearch;

/**
 * 704. Binary Search
 * Given an array of integers nums which is sorted in ascending order,
 * and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left <= right){ // <= because we need to check left==right
            int mid = left + (right - left) /2;

            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // If target not found
        return -1;
    }
}

/**
 * 1) while (left <= right) → Standard Binary Search (find exact element)
 * Use this when you want to check every index, including when left == right.
 * Typical pattern: searching for a specific value
 * After the loop, if not found, you return -1 (or another “not found” indicator).
 *
 * 2) while (left < right) → Search for insertion position / lower bound
 * Use this when you are finding first position that satisfies a condition, not necessarily an exact match.
 * Loop stops when left == right → left is the position you want.
 * Often used in “search for insert position” problems.
 */
