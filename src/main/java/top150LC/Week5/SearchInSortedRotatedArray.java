package org.Week5;
// ???????????????????????????          DO IT AGAIN                   ?????????????????????????
//Modified Binary search
public class SearchInSortedRotatedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left<=right){ //if array has single element then both will point to the same element
            int mid = left + (right - left)/2;
            if(nums[mid]==target){
                return mid;
            }
            //if we are on the left sorted portion of the array?
            else if(nums[left] <= nums[mid]){
                if(target> nums[mid] || target < nums[left]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
            // right sorted portion?
            else{
                if(target < nums[mid] || target > nums[right]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        return -1;
    }
}
