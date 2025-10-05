package top75LC.Week2;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: candies = [2,3,5,1,3], extraCandies = 3
 * Output: [true,true,true,false,true]
 * Explanation: If you give all extraCandies to:
 * - Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
 * - Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
 * - Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
 * - Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
 * - Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
 */

public class KidsWithGreatestCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maxCandy = 0;
        //find max candy
        for(int candy: candies){
            maxCandy = Math.max(candy, maxCandy);
        }
        for(int c: candies){
            if(c+extraCandies >= maxCandy){
                result.add(true);
            }else{
                result.add(false);
            }
        }
        return result;
    }
}
//TC = O(n)
//SC = O(n)