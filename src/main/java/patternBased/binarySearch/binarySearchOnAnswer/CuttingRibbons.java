package patternBased.binarySearch.binarySearchOnAnswer;
// 1891. Cutting Ribbons

/**
 * Your task is to determine the maximum length of ribbon, x,
 * that allows you to cut at least k ribbons, each of length x.
 * You can discard any leftover ribbon from the cuts. If it is impossible to cut k ribbons
 * of the same length, return 0.
 * Input: ribbons = [9,7,5], k = 3
 * Output: 5
 * Input: ribbons = [7,5,9], k = 4
 * Output: 4
 * Input: ribbons = [5,7,9], k = 22
 * Output: 0
 */
public class CuttingRibbons {
    public int maxLength(int[] ribbons, int k) {
        //ribbons[i] = length of ith ribbon
        //k - cut k ribbons each of length x
        //return max possible length of ribbon
        // Binary search of last TRUE
        int low = 1; //ribbon of length 0 is meaningless that is why = 1, the smallest valid piece you can cut is 1 unit.
        int high = 0;
        for(int ribbon : ribbons){
            high = Math.max(high, ribbon);
        }
        int countLen = 0;
        while(low<=high){ //since we are finding Last True
            int mid = low + (high-low)/2;
            if(canCut(ribbons, k, mid)){
                countLen = mid;
                low = mid+1;
            } else {
                high = mid -1;
            }
        }
        return countLen;
    }
    private boolean canCut(int[] ribbons, int k, int length) {
        int pieces = 0;
        for(int r : ribbons) {
            pieces += r / length; //how many lengths the ribbon length be broken into, like 9/3=3 or 9/4 = 2
        }
        return pieces >= k;
    }
}
//TC = O(n log maxRibbon)
/**
 1-->True (Min)
 2-->True
 3-->True
 4-->True
 5-->True (Max)
 6--> False
 */
/**
 low = 1, high = 9, ans = 0
 mid = 1+ (9-1)/2 = 5
 Check if length = 5 works: 9 / 5 = 1, 7 / 5 = 1, 5 / 5 = 1
 Total pieces = 3, 3 >= k (i.e.,3)
 now low = mid+1 = 6
 iteration2: low = 6, high = 9 so mid = 7
 9/7 =1, 7/7 = 1, 5/7 = 0 count = 2 which is less than k so false
 Now high = mid-1 = 6
 iteration 3: low = 6, high = 6, so mid = 6
 9/6= 1, 7/6 = 1, 5/6 = 0 so count = 2 which is less than k so FALSE
 so high = mid-1 = 5
 Iteration4: low = 6, high = 5, while loop exits, so ans = 5.
 */
