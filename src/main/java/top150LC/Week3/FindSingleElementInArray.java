package top150LC.Week3;

public class FindSingleElementInArray {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length-1;

        while(left < right){
            int mid = left + (right-left)/2;
            //Case1: When the mid index is even
            if(mid%2 == 0){
                if(nums[mid] == nums[mid+1]){//correct behaviour
                    left = mid+2; // search on the right side
                }else{
                    right = mid;//broken behaviour so search on the left side
                }
            }
            //Case2: when the mid index is odd
            else {
                if(nums[mid] == nums[mid-1]){
                    left = mid + 1;//correct behaviour so search on the right side
                }else {
                    right = mid - 1; //broken behavior so search on the left side
                }
            }
        }
        return nums[left]; //when left == right then we should return the single element
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
 * Because----->
 * low ... mid ... high
 * eventually, low == high = single element
 * If low < high → keep searching.
 * If low == high → stop and return nums[low].
 */
