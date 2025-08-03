package org.Week1;

/**
 *Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 */

/**
 * https://algo.monster/liteproblems/169
 */

// Using the Moore Voting Algorithm to find the majority element.
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int majorityEle = 0;

        for(int n:nums){
            if (cnt == 0){
                majorityEle = n;
                cnt = 1;
            }else {
                if (n == majorityEle){
                    cnt++;
                }else{
                    cnt--;
                }
            }
        }
        return majorityEle;
    }
}

//TC = O(n)
//SC = O(1)