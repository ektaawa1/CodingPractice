package top150LC.Week2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//15. 3Sum https://algo.monster/liteproblems/15

// 2 pointers approach
// so sort it first

//for Three Sum, since we only care about triplet values and not positions, sorting is both valid and helpful —
// it enables the two-pointer pattern and simplifies duplicate handling.

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that
 * i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Two-Pointer Technique: We start the two-pointer process with i, j, and k as follows:
 * i = 0: We choose -4 as the first element.
 * j = i + 1: j starts at -1 (the element right after -4).
 * k = n - 1: k starts at 2 (the last element).
 * Find the Triplets: In the while loop, we find sums of nums[i] + nums[j] + nums[k] and
 * adjust j and k accordingly.
 * Each time we find a triplet, we move both j and k while they point to the same number
 * to avoid duplicates. In this case, there are no duplicates, and we are done with this iteration.
 */

//Sort the array.
//Fix one element (nums[i]).
//Use two pointers (left, right) or(j, k) to find two numbers that sum to -nums[i].
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort to avoid duplicates

        int arrSize = nums.length;
        //The "Breathing Room" Logic, if n = 5 then if i is at index 2 then L should be at 3 & R at 4 (i.e n-1)
        for(int i = 0; i<arrSize-2; i++){
            //skip duplicate elements
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i+1;
            int r = arrSize-1;

            while(l<r){
                int sum = nums[i] + nums[l] + nums[r];

                if(sum == 0){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    // Step 3: Skip duplicates for L and R
                    while(l<r && nums[l] == nums[l+1]) l++;
                    while(l<r && nums[r] == nums[r-1]) r--;
                    l++;
                    r--;
                } else if(sum < 0){
                    l++;
                } else {
                    r--;
                }
            }//while loop ends here
        }
        return res;
    }
}

// TC = O(n^2)
// SC = O(m) where Where m is the number of triplets and n is the length of the given array.
/**
 * Brute Force- Sort the Array, Add the index list in a HashSet, Finally add set in List- outputList.addALL(set1) and return it;
 * TC = O(n^3), SC = O(n)
 * public List<List<Integer>> findThreeSum(int[] arr){
 *     List<List<Integer>> outputList = new ArrayList<>();
 *     Set<List<Integer>> set1 = new HashSet<>();
 *
 *     Arrays.sort(arr);//sort it
 *     for(int i = 0; i<arr.length;i++){
 *       for(int j = i+1; j<arr.length; j++){
 *         for(int k = j+1; k<arr.length; k++){
 *           int sum = arr[i] + arr[j] + arr[k];
 *           if(sum > 0 || sum < 0){
 *             continue;
 *           }else{
 *             set1.add(Arrays.asList(arr[i], arr[j], arr[k]));
 *           }
 *         }
 *       }
 *     }
 *     outputList.addAll(set1);
 *     return outputList;
 *   }
 *   public static void main(String[] args) {
 *     int arr[] ={-1, 0, 1, 2, -1, -4};
 *     List<List<Integer>> outputList = new Solution().findThreeSum(arr);
 *     System.out.println(outputList);
 *   }
 */
