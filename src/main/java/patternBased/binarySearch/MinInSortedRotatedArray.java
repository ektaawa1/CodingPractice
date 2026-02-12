package patternBased.binarySearch;
//Using Binary Search here
public class MinInSortedRotatedArray {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int mid = l + (r-l)/2;
            if(nums[mid]> nums[r]){
                l = mid+1;// Min must be in right half
            }else{
                r = mid; // Min could be at mid or in left half
            }
        }
        return nums[l]; // left == right at this point
    }
    public int findMinBetter(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        //int min = nums[0];

        while(low < high){
            int mid = low + (high-low)/2;
            if(nums[mid] < nums[high]){
                high = mid; //search on the left side
            } else {
                low = mid +1;
            }
        }
        return nums[low];
    }
}
//Explanation-
/**
 * Optimal Binary Search Approach — O(log n):
 * Core Idea:
 * In a rotated sorted array, one half is always sorted.
 * If the middle element is greater than the rightmost, the min must be on the right side.
 * If the middle is smaller than the rightmost, the min is on the left side (including mid).
 */

/**
 * Why Your O(n) Approach Works But Isn’t Optimal:
 * Your two-pointer scan works like this:
 * Set left = 0, right = n - 1.
 * Compare nums[left] and nums[right].
 * Move the pointer pointing to the larger value inward.
 * Keep track of the minimum.
 * This works because you eventually check all elements.
 * But it's O(n) in the worst case, and not leveraging the sorted & rotated structure.
 */


