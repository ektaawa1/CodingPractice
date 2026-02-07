package patternBased.twoPointers;

//Dutch National Flag
//Example- {2,0,2,1,1,0}

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 */

/** Explanation-
 * We maintain three sections: 0’s to the left, 1’s in the middle, 2’s to the right.
 * current traverses the unknown section.
 * 0 → swap left, move both pointers
 * 2 → swap right, recheck current
 * 1 → move current
 * This ensures every element is placed correctly in a single pass.
 */
public class SortColors {
    //single pass solution- more optimized
    public void sortColors(int[] nums) {
        //3 pointers approach
        int left = 0;
        int mid = 0;
        int right = nums.length-1;

        while(mid <= right){
            if(nums[mid] == 0){
                int temp = nums[left];
                nums[left] = nums[mid];
                nums[mid] = temp;
                left++;
                mid++;
            } else if(nums[mid] == 1){
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[right];
                nums[right] = temp;
                right--;
            }
        }
    }
    //2 pass solution- You can use one pointer and two passes (less optimal)
    public void sortColors2Pass(int[] nums) {
        // First: Move all 0s to left side
        int j = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 0){
                swapElements(i,j,nums);
                j++;
            }
        }
        // Second: Move all 1s after 0s
        for(int i = j; i<nums.length; i++){
            if(nums[i] == 1){
                swapElements(i,j,nums);
                j++;
            }
        }
    }
    private void swapElements(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
//Time: O(n) — one pass, each element swapped/inspected a constant number of times.
//Space: O(1) extra — in-place.

/**
 * Dutch National Flag Algo- O(n) times & O(1) Space complexity
 If arr[mid]== 0 then swap it with arr[low], increment both
 If arr[mid] == 1 then increment just mid pointer
 If arr[mid] == 2 then swap with arr[high], decrement just high pointer

 Brute Force Algo- Sort the array [O(n log n) times] or take 3 counters [O(n) times] & count the no of 0s, 1s, 2s and finally set the no of 0s, 1s & 2s
 manually using 3 seperate for loops
 */

