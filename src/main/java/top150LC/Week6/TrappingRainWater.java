package top150LC.Week6;
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
        int lMax = 0; int rMax = 0;
        int totTrappedWater = 0;

        while(left < right){
            if(height[left]< height[right]){
                if(height[left] >= lMax){
                    lMax = height[left]; // update left max
                } else {
                    totTrappedWater += lMax -height[left]; // trap water
                }
                left++;

            } else { // if height of right is less than height of left
                if(height[right] >= rMax){
                    rMax = height[right]; // update right max
                } else {
                    totTrappedWater += rMax - height[right]; // trap water
                }
                right--;
            }
        }
        return totTrappedWater;
    }
    // SC = O(n) since we are using extra space
    public int trap1(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int water = 0;

        // Fill left max
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        // Fill right max
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        // Calculate water
        for (int i = 1; i < n - 1; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return water;
    }

}
