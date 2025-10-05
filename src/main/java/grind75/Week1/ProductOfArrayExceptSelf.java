package grind75.Week1;

/**
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.

 * Example 1: Input: nums = [1,2,3,4], Output: [24,12,8,6]
 * Example 2: Input: nums = [-1,1,0,-3,3], Output: [0,0,9,0,0]
 */
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int result[] = new int[nums.length];
        int left =1;
        int right = 1;
        // Calculate Prefix Product
        for(int i = 0; i<nums.length; i++){
            result[i] = left;
            left = left * nums[i];//update the left pointer
            // result [] = [1, 1, 2, 6]
            //left = 1--> 2--> 6--> 24
        }
        // Calculate Suffix product and multiply to update the result array
        for(int j = nums.length-1; j>=0; j--){
            result[j] = result[j]*right;
            right = right * nums[j];
            // result[] = [1, 1, 2, 6] ==> [24, 12,  8, 6]
            // right = 4 --> 12 --> 24 --> 24
        }
        return result;
    }
    // Brute Force Solution
    public int[] productExceptSelf1(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    product *= nums[j];
                }
            }
            result[i] = product;
        }
        return result;
    }
}
// [1, 2, 3, 4]
// [1, 1, 2, 6] ---> Left ==>
// [24, 12, 4, 1] ---> Right
// [24, 12, 8, 6] ---> Output

/**
 * For index 0: 2*3*4 = 24
 * For index 1: 1*3*4 = 12
 * For index 2: 1*2*4 = 8
 * For index 3: 1*2*3 = 6
 *
 * Instead of recalculating every time:
 * prefix[i] = product of all elements to the left of i
 * suffix[i] = product of all elements to the right of i
 * Then:
 * result[i] = prefix[i] * suffix[i]
 */
//Brute Force O(n²): Multiply everything for each index.
//Prefix + Suffix O(n): Precompute left and right products.
//Optimized O(n), O(1) space: Store prefix in result, then multiply by running suffix.