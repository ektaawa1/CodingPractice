package top75LC.Week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Example 1:Input: nums1 = [1,2,3], nums2 = [2,4,6], Output: [[1,3],[4,6]]
 * Explanation:
 * For nums1, nums1[1] = 2 is present at index 0 of nums2, whereas nums1[0] = 1 and nums1[2] = 3 are not present in nums2. Therefore, answer[0] = [1,3].
 * For nums2, nums2[0] = 2 is present at index 1 of nums1, whereas nums2[1] = 4 and nums2[2] = 6 are not present in nums1. Therefore, answer[1] = [4,6].
 *
 * Example 2: Input: nums1 = [1,2,3,3], nums2 = [1,1,2,2], Output: [[3],[]]
 * Explanation:
 * For nums1, nums1[2] and nums1[3] are not present in nums2. Since nums1[2] == nums1[3], their value is only included once and answer[0] = [3].
 * Every integer in nums2 is present in nums1. Therefore, answer[1] = [].
 */
public class DifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for(int num1 : nums1){
            set1.add(num1);
        }
        for(int num2 : nums2){
            set2.add(num2);
        }
        for(int n1: set1){
            if(!set2.contains(n1)){
                list1.add(n1);
            }
        }
        for(int n2: set2){
            if(!set1.contains(n2)){
                list2.add(n2);
            }
        }
        return Arrays.asList(list1, list2);
    }
}

//Time: O(n + m), where n and m are lengths of nums1 and nums2
//
//Space: O(n + m) for the sets and output lists
