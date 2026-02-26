package patternBased.slidingWindow;
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
            while(oddCount>k){
                    if(nums[left]%2==1){
                        oddCount--;
                    }
                    left++;
                }

            if(oddCount == k){ //The current window [left … right] contains exactly k odd numbers. So, Count how many even numbers exist before first odd in current window
                int tempLeft = left;
                //Because each even can be removed from the left without affecting odd count.
                while(tempLeft < nums.length  && nums[tempLeft] %2 == 0) tempLeft++;
                result += tempLeft-left+1;
                //Each even can be removed without changing odd count.
                //Only the ones BEFORE the first odd number.
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
