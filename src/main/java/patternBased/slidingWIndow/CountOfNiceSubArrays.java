package patternBased.slidingWIndow;
// 1248. Count Number of Nice Subarrays

/**
 * Given an array of integers nums and an integer k.
 * A continuous subarray is called nice if there are k odd numbers on it.
 *
 * Return the number of nice sub-arrays.
 */
public class CountOfNiceSubArrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0;
        int oddCount = 0;
        int result = 0;

        for(int right = 0; right < nums.length; right++){
            if(nums[right]%2 == 1){
                oddCount++;
            }
            if(oddCount > k){
                while(oddCount>k){
                    if(nums[left]%2==1){
                        oddCount--;
                    }
                    left++;
                }
            }
            if(oddCount == k){
                int tempLeft = left;
                while(tempLeft < nums.length  && nums[tempLeft] %2 == 0) tempLeft++;
                result += tempLeft-left+1;
            }

        }
        return result;
    }
}
/**
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 *
 * Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * Output: 16
 *
 * Input: nums = [2,4,6], k = 1
 * Output: 0
 * Explanation: There are no odd numbers in the array.
 */
