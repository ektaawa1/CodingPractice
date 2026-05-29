package top150LC.Week5;

import java.util.HashSet;

/**
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Because the longest consecutive sequence is: 1, 2, 3, 4
 */
public class LongestConsecutiveSeq {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numsSet = new HashSet<>();
        int longestCount = 0;
        //put all numbers in a HashSet for O(1) lookup, no duplicates
        for(int n: nums){
            numsSet.add(n);
        }
        for(int i: numsSet){
            //start counting a chain from numbers that have no left neighbor
            if(!numsSet.contains(i-1)){
                int currCount = 1;
                int currNum = i;
                while(numsSet.contains(currNum+1)){
                    currNum += 1;
                    currCount += 1;
                }
                longestCount = Math.max(longestCount, currCount);
            }
        }
        return longestCount;
    }
}
//TC = O(n)+O(n) = O(n)

/**
 * 1 has no left neighbor (0 doesn't exist) → START HERE
 * 2 has left neighbor 1 → SKIP
 * 3 has left neighbor 2 → SKIP
 * 4 has left neighbor 3 → SKIP
 * 100 has no left neighbor → START HERE
 * 200 has no left neighbor → START HERE
 */
