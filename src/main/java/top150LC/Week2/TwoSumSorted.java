package top150LC.Week2;

// 167. Two Sum II - Input Array Is Sorted

//2 pointers approach
// https://www.youtube.com/watch?v=cQ1Oz4ckceM
// https://neetcode.io/problems/two-integer-sum-ii

public class TwoSumSorted {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;

        while(l<r){
            int sum = numbers[l] + numbers[r];
            if(sum > target){
                r--;
            } else if(sum < target){
                l++;
            } else {
                return new int[] {l+1, r+1};
            }
        }
        return new int[] {};
    }
}
// TC O(n)
// SC O(1)
