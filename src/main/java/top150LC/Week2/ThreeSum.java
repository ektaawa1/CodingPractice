package org.Week2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//15. 3Sum https://algo.monster/liteproblems/15

// 2 pointers approach
// so sort it first

/**
 * Two-Pointer Technique: We start the two-pointer process with i, j, and k as follows:
 * i = 0: We choose -4 as the first element.
 * j = i + 1: j starts at -1 (the element right after -4).
 * k = n - 1: k starts at 2 (the last element).
 * Find the Triplets: In the while loop, we find sums of nums[i] + nums[j] + nums[k] and
 * adjust j and k accordingly.
 * Each time we find a triplet, we move both j and k while they point to the same number
 * to avoid duplicates. In this case, there are no duplicates, and we are done with this iteration.
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        int len = nums.length;

        for(int i = 0; i< len-2 && nums[i] <= 0; i++){
            if(i > 0 && nums[i] == nums[i-1]){ //handling duplicates
                continue;
            }

            int j = i + 1;
            int k = len - 1;

            // two pointers aprroach
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0){
                    j++;
                } else if(sum > 0){
                    k--;
                } else {
                    //adding result to the output list
                    output.add(List.of(nums[i], nums[j], nums[k]));
                    // handling duplicates
                    while(j<k && nums[j] == nums[j+1]){
                        j++;
                    }
                    while(j<k && nums[k] == nums[k-1]){
                        k--;
                    }
                    j++;
                    k--;
                }
            }
        }
        return output;
    }
}

// TC = O(n^2)
// SC = O(m) where Where m is the number of triplets and n is the length of the given array.
