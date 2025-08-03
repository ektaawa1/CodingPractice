package org.Week1;

// Leetcode
//88. Merge Sorted Array
//Merge nums1 and nums2 into a single array sorted in non-decreasing order.

/**
 * Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 **/

/**
 * https://dev.to/rahulgithubweb/leetcode-challenge-merge-sorted-array-top-interview-questions-java-solution-dpa
 * https://algo.monster/liteproblems/88
 */

public class MergeSortedArray {
    public void merge(int nums1[], int m, int[] nums2, int n){
        // two pointers approach
        int i = m-1;
        int j = n-1;

        int k = m+n-1;

        while ( i >= 0 && j >=0){
            if (nums1[i] > nums2[j]){
                nums1[k--] = nums1[i--];
            }else{
                nums1[k--] = nums2[j--];
            }
        }

        while (j >= 0){
            nums1[k--] = nums2[j--];
        }
    }
}

//Time Complexity = O(m+n) We are iterating through both the arrays once
// Space Complexity =  O(1) No extra space is needed, the merge is done in-place