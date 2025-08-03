package org.Week5;

import java.util.HashSet;

public class LongestConsecutiveSeq {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numsSet = new HashSet<>();
        int longestCount = 0;
        for(int n: nums){
            numsSet.add(n);
        }
        for(int i: numsSet){
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
