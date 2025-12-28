package otheTopicsExample;

//Given an integer array nums, return true if any value appears at least twice in the array,
// and return false if every element is distinct.

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Example 1:
 * Input: nums = [1,2,3,1], Output: true
 * Explanation: The element 1 occurs at the indices 0 and 3.
 */
public class ContainsDuplicates {
    public boolean containsDuplicate(int[] nums) {
        //When Speed matters or When array can't be modified
        HashSet<Integer> set1 = new HashSet<>();

        for(int num : nums){
            if(!set1.contains(num)){
                set1.add(num);
            }
            else{
                return true;
            }
        }
        return false; //stops early when duplicates found
    } // Or
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);
        return nums.length != set.size(); //Cannot early exit, always loops entire array.
    } //O(n) TC
    //When Memory is limited, then use sorting
    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);  // O(n log n)
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) return true;
        }
        return false;
    }
}
