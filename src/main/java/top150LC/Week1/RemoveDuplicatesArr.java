package top150LC.Week1;


// https://algo.monster/liteproblems/26

/**
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * Example 2:
 *
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */

// 2 pointers technique
public class RemoveDuplicatesArr {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;

        int k = 1;
        for(int right = 1; right < nums.length; right++){
            if(nums[right] != nums[right-1]){
                nums[k++] = nums[right];
            }
        }
        return k;
    }
}

//TC = O(n)
//SC = O(1)

