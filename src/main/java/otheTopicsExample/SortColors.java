package otheTopicsExample;

//Dutch National Flag
//Example- {2,0,2,1,1,0}

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            }
            else if (nums[mid] == 1) {
                mid++;
            }
            else {  // nums[mid] == 2
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void sortColors1(int[] nums) {
        //3 pointers approach
        int low = 0;
        int mid = 0;
        int high = nums.length-1;

        while(mid <= high){
            if(nums[mid] == 0){
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if(nums[mid] == 1){
                mid++;
            } else {
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
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
