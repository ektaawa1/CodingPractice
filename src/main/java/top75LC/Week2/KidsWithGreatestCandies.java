package top75LC.Week2;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: candies = [2,3,5,1,3], extraCandies = 3
 * Output: [true,true,true,false,true]
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