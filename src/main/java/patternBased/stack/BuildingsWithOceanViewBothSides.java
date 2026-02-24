package patternBased.stack;

import java.util.ArrayList;
import java.util.List;

public class BuildingsWithOceanViewBothSides {
    public int[] findBuildings(int[] heights) {
        int n = heights.length;
        boolean[] hasView = new boolean[n];

        // Check ocean view to the right
        int maxRight = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (heights[i] > maxRight) {
                hasView[i] = true;
                maxRight = heights[i];
            }
        }

        // Check ocean view to the left
        int maxLeft = -1;
        for (int i = 0; i < n; i++) {
            if (heights[i] > maxLeft) {
                hasView[i] = true;
                maxLeft = heights[i];
            }
        }

        // Collect indices in order
        List<Integer> result = new ArrayList<>();// Using List becoz We don’t know the final size of the result beforehand.
        for (int i = 0; i < n; i++) {
            if (hasView[i]) result.add(i);
        }

        // Convert to array
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}
//TC = O(n), SC = O(n)
