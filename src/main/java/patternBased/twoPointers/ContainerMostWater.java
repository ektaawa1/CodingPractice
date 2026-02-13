package patternBased.twoPointers;

// 2 pointers approach is used here
public class ContainerMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxWater = 0;

        while(left < right){
            //calculate height of water
            //Water level = minimum of the two heights
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            int area = width * h;
            //calculate the max area
            maxWater = Math.max(maxWater, area);
            //idea is to move the smaller height pointer inwards (left or right pointer)
            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}

/**
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */

/**
 * Brute Force- O(n^2)
 * for (int i = 0; i < n; i++) {
 *    for (int j = i+1; j < n; j++) {
 *       area = (j - i) * Math.min(height[i], height[j]);
 *    }
 * }
 */
