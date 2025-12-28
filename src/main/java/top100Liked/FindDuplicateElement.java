package top100Liked;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 * You must solve the problem without modifying the array nums and using only constant extra space.
 */
public class FindDuplicateElement {
    public int findDuplicate(int[] nums) {
        //slow and fast pointer approach
        int slow = nums[0];
        int fast = nums[0];
        //Step 1: detect the cycle
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        //Step 2: find the duplicate
        int prev = nums[0];
        while(slow != prev){
            slow = nums[slow];
            prev = nums[prev];
        }
        return prev;
    }
}
/**
 Time: O(n)

 Space: O(1)

 Array is not modified
 */
/**
 * Examples-
 * Example 1:Input: nums = [1,3,4,2,2]
 * Output: 2
 *
 * Example 2:Input: nums = [3,1,3,4,2]
 * Output: 3
 *
 * Example 3:Input: nums = [3,3,3,3,3]
 * Output: 3
 */