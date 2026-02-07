package patternBased.twoPointers;

// 167. Two Sum II - Input Array Is Sorted
//2 pointers approach

//Note: If array is sorted and we are finding a pair → think Two Pointers FIRST
//Is the array sorted? Finding a pair or a triplet?
public class TwoSumSorted {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;

        while(l<r){
            int sum = numbers[l] + numbers[r];
            if(sum > target){ //too large
                r--;
            } else if(sum < target){ //too small
                l++;
            } else { //found the answer
                return new int[] {l+1, r+1};
            }
        }
        return new int[] {};
    }
}
// TC O(n)
// SC O(1)
