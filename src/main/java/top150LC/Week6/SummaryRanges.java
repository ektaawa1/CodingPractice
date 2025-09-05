package top150LC.Week6;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> output = new ArrayList<>();
        int len = nums.length;
        int i = 0;

        while(i<len){
            int start = nums[i];
            // keep moving while consecutive numbers are present
            while(i+1 < len && nums[i+1] == nums[i]+1){
                i++;
            }

            int end = nums[i];

            if(start == end){
                output.add(String.valueOf(start));
            } else {
                output.add(start + "->" + end);
            }
            i++;
        }
        return output;
    }
}

// TC = O(n)
// SC = O(1) excluding output list
