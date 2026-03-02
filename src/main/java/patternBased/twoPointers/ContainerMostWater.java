package patternBased.twoPointers;
//11. Container With Most Water

/**
 *Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Input: height = [1,1]
 * Output: 1
 */

// 2 pointers approach is used here
public class ContainerMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxArea = 0;

        while(left < right){
            //calculate height of water
            //Water level = minimum of the two heights
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            int area = width * h;
            //calculate the max area
            maxArea = Math.max(maxArea, area);
            //idea is to move the smaller height pointer inwards (left or right pointer)
            if(height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
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
