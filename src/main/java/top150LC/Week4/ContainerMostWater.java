package org.Week4;

// 2 pointers approach is used here
public class ContainerMostWater {
    public int maxArea(int[] height) {
        // Area = Width * Height i.e. (j-i) * Min(h1, h2)
        int l = 0;
        int r = height.length-1;
        int res = 0;

        while(l<r){
            int maxArea = (r-l) * Math.min(height[l], height[r]);
            res = Math.max(maxArea, res);
            if(height[l]<=height[r]){
                l++;
            } else {
                r--;
            }
        }
        return res;
    }

    public int maxArea1(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            int area = h * width;
            maxArea = Math.max(maxArea, area);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
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
