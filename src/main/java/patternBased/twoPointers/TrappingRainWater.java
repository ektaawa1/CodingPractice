package patternBased.twoPointers;
// YouTube Explanation- https://www.youtube.com/watch?v=UHHp8USwx4M
/**
 * Example1-
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 * Explanation: The above elevation map (black section) is represented by array
 * [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 *
 * Example 2: Input: height = [4,2,0,3,2,5], Output: 9
 */

//Formula- min(leftMax, rightMax)- ithHeight
public class TrappingRainWater {
    // 2 pointers approach, TC =O(n), SC = O(1)
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxLeft = 0; //tallest bar seen so far from the left
        int maxRight = 0;
        int totTrappedWater = 0;

        while(left < right){
            if(height[left]< height[right]){ //(smaller height)
                if(height[left] >= maxLeft){ //decides whether we update maxLeft or add trapped water
                    maxLeft = height[left]; // update left max
                } else {
                    //If current bar is shorter than maxLeft, it forms a valley → water can sit on it
                    totTrappedWater += maxLeft -height[left]; // trap water
                }
                left++;

            } else { // if height of right is less than height of left
                if(height[right] >= maxRight){
                    maxRight = height[right]; // update right max
                } else {
                    totTrappedWater += maxRight - height[right]; // trap water
                }
                right--;
            }
        }
        return totTrappedWater;
    }
    public int trap1(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxLeft = 0; int maxRight = 0;
        int trappedWater = 0;

        while(left < right){
            maxLeft = Math.max(maxLeft, height[left]);
            maxRight = Math.max(maxRight, height[right]);

            if(maxLeft < maxRight){
                trappedWater += maxLeft-height[left];
                left++;
            } else {
                trappedWater += maxRight-height[right];
                right--;
            }
        }
        return trappedWater;
    }
}
/**
 * Time complexity:
 * O(N), where N is size of height array.
 *
 * Space complexity:
 * O(1), no extra space is used.
 */
