package top150LC.Week1;

/**
 *Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3], Output: 3
 *
 * Example 2:
 * Input: nums = [2,2,1,1,1,2,2], Output: 2
 */

import java.util.HashMap;

/**
 * https://algo.monster/liteproblems/169
 */

// Using the Moore Voting Algorithm to find the majority element.
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 0;
        int majorityEle = 0;

        for(int n:nums){
            if (count == 0){
                majorityEle = n;
                count = 1;
            }else {
                if (n == majorityEle){
                    count++;
                }else{
                    count--;
                }
            }
        }
        return majorityEle;
    }
    //using a hashmap- brute force TC = O(n), SC = O(n)
    public int majorityElementBF(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1; // won't reach since majority always exists
    }

}

//TC = O(n)
//SC = O(1)