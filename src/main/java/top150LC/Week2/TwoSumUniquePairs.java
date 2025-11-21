package top150LC.Week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Return all unique pairs (a, b) such that a + b = target.
 * Input may contain duplicates → output pairs must NOT repeat.
 * Example-
 * nums = [1, 1, 2, 2, 3, 4], target = 5
 * Output = [[1,4], [2,3]]
 */
public class TwoSumUniquePairs {
    //APPROACH-
    //Sort the array, Use two pointers
    //Skip duplicates so each pair appears only once

    public List<List<Integer>> twoSumUnique(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sorting helps skip duplicates

        int left = 0, right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (sum == target) {
                result.add(Arrays.asList(nums[left], nums[right]));

                // Move both pointers
                left++;
                right--;

                // Skip duplicates on left
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }

                // Skip duplicates on right
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }

            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
