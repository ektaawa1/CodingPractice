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
    public List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> outputList = new ArrayList<>();
        Arrays.sort(arr); //to avoid the duplicates

        int arrSize = arr.length;

        for(int i = 0; i<arrSize-2; i++){
            //skip duplicate elements
            if(i > 0 && arr[i] == arr[i-1]){
                continue;
            }
            int left = i+1;
            int right = arrSize-1;

            while(left<right){
                int sum = arr[i] + arr[left] + arr[right];

                if(sum == 0){
                    outputList.add(Arrays.asList(arr[i], arr[left], arr[right]));

                    //moving past duplicates
                    while(left<right && arr[left] == arr[left+1]) left++;
                    while(left<right && arr[right] == arr[right-1]) right--;
                    left++;
                    right--;
                } else if(sum < 0){
                    left++;
                } else {
                    right--;
                }
            }//while loop ends here
        }
        return outputList;
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
