package top150LC.Week4;

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
    //just the 1st occurence
    //When you find the target: Store the index and then Continue searching LEFT
    public int firstOccurrence(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                ans = mid;          // store answer
                right = mid - 1;    // move left
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
    //Just the last occurence?
    //When you find the target: Store the index then Continue searching RIGHT
    public int lastOccurrence(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                ans = mid;         // store answer
                left = mid + 1;    // move right
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

}

/**
 * Why Two Pointers Isn't Ideal:
 * Two pointers = linear scan, which takes O(n) in the worst case (e.g., all elements are the target).
 * But since the array is sorted, we can exploit that and use binary search to find:
 * The first occurrence of the target
 * The last occurrence of the target
 */

//Note: We use left <= right because when left == right, there is still one element left to check. If we stop earlier, we might miss the target — especially when searching for the first or last occurrence.
//Example- nums = [5], target = 5
//left = 0, right = 0 and hence you use left <= right
