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
    //this one
    //the shorter boundary determines the water level.
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
 * Space complexity: due to 2 pointer's approach
 * O(1), no extra space is used.
 */

/**
 * At any bar, water it can hold =
 * min(tallest bar on left, tallest bar on right) - its own height
 *
 * For Example -
 * height = [4, 2, 0, 3, 1]
 * At index 2 (height=0):
 *   Tallest seen from left  = max(4,2,0) = 4  ← maxLeft
 *   Tallest seen from right = max(1,3,0) = 3  ← maxRight
 *   Water = min(4,3) - 0 = 3
 *
 * Brute force would compute maxLeft and maxRight for every index → O(n²).
 * Two pointer does it in O(n) by using this one observation:
 * If maxLeft < maxRight:
 *
 * The LEFT side is the limiting factor
 * Water at left pointer = maxLeft - height[left]
 * We don't need to know exact maxRight — we already know it's taller than maxLeft, so min is maxLeft regardless
 * Process left, move left pointer inward
 *
 * If maxRight <= maxLeft:
 *
 * The RIGHT side is the limiting factor
 * Water at right pointer = maxRight - height[right]
 * We don't need to know exact maxLeft — it's taller than maxRight, so min is maxRight regardless
 * Process right, move right pointer inward
 */
