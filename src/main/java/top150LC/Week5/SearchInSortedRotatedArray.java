package top150LC.Week5;

/**
 * There is an integer array nums sorted in ascending order (with distinct values).
 * Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].
 * Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 * You must write an algorithm with O(log n) runtime complexity.
 */
//Modified Binary search
public class SearchInSortedRotatedArray {
    public int search(int[] nums, int target) {
        if(nums.length == 0 || nums == null){
            return -1;
        }
        int low = 0;
        int high = nums.length-1; // index: 0-6
        while(low <= high){
            int mid = low + (high-low)/2; //to avoid integer overflow

            if(nums[mid] == target){
                return mid;
            }
            // if on the left side
            if(nums[low] <= nums[mid]){
                if(target >= nums[low] && target < nums[mid]){
                    high = mid - 1; //search left side
                } else {
                    low = mid + 1;  // search right half
                }
            }
            //if on the right side
            else {
                if (target > nums[mid] && target <= nums[high]) {
                    low = mid + 1;  // search right half
                } else {
                    high = mid - 1; // search left half
                }
            }
        }
        return -1;
    }
}
//[4,5,6,7,0,1,2]  target = 0 Modified Binary Search
//Find mid
//if nums[mid] == target, retrun mid
// if nums[mid] > target, mid = mid+1
// if nums[mid] < target, mid = mid-1

//TC = O(log n)
//SC = O(1)
