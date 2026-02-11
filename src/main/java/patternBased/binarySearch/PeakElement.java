package patternBased.binarySearch;

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

/**
 * Peak element is:
 * nums[i] > nums[i-1] & nums[i] > nums[i+1]
 * we will only check nums[mid] vs nums[mid+1] since BS is applied in sorted array right so we just focus on
 * transition eg- 1,2,3,1 (3,1 is the transition)
 * Why?
 * Because we can determine the direction of slope.
 * Think of array like a mountain range: 1,2,3,1
 * If at mid ==> nums[mid] < nums[mid+1] ==> we are going up, which mean peak will be on right side
 * If at mid ==> nums[mid] > nums[mid+1] ==> we are going down, which means peak will be on left or at mid.
 */
public class PeakElement {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while(left<right){
            int mid = left + (right-left)/2;

            if(nums[mid] > nums[mid+1]){
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
// TC = O(log n)
