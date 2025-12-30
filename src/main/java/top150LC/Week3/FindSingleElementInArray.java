package top150LC.Week3;

public class FindSingleElementInArray {
    public int singleNonDuplicate(int[] nums) {
        //binary search
        int low = 0;
        int high = nums.length-1;

        while(low < high){
            int mid = low + (high-low)/2;
            //Case1: if mid is even
            if(mid%2 == 0){
                if(nums[mid] == nums[mid+1]){
                    //// correct pairing → single is on right
                    low = mid+2; //i.e, the single no is on right side
                }else{
                    //// broken pairing → single is on left or mid
                    high = mid; // i.e., the single no is either mide or on the left side
                }
            }
            //Case2: if mid is odd
            else {
                if(nums[mid] == nums[mid-1]){
                    //// correct pairing → single is on right
                    low = mid+1;// the single number is on the right side
                }else {
                    //// broken pairing → single is on left
                    high = mid - 1; // the single number is on the left side
                }
            }
        }
        return nums[low];
    }
}
//O(log n) time and O(1) space.
/**
 * Note:
 * • Left side → pairs start at EVEN index
 * • Right side → pairs start at ODD index
 *
 * At index mid:
 * Case 1: mid is EVEN
 * LEFT side → nums[mid] == nums[mid+1]
 * RIGHT side → nums[mid] == nums[mid-1]
 *
 * Case 2: mid is ODD
 * LEFT side → nums[mid] == nums[mid-1]
 * RIGHT side → nums[mid] == nums[mid+1]
 */
/**
 * Why not while(low <= high){...}
 */
