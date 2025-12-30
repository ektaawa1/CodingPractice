package otheTopicsExample;

public class KthMissingPositiveNum {
    public int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            //find how many numbers are missing till index mid
            int missingCount = arr[mid]-(mid+1); //where actual value at mid would have been (mid+1)
            if(missingCount<k){
                left = mid+1;//move right if still not enough missing numbers
                //The k-th missing number is to the right
            }else{
                right = mid-1;// too many missing numbers, We went too far..
            }
        }
        //value at position left = left + 1
        return left+k;//But we want the k-th missing number, so shift by k
    }
}
//Linear scan → O(n) time, O(1) space
//Binary search → O(log n) time, O(1) space
/**
 * Important Note:
 * Expected number at index i = i + 1
 * Actual number = arr[i]
 * Missing count till index i = arr[i] - (i + 1)
 */
