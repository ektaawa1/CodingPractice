package top150LC.Week8;

import java.util.*;

/**
 * Approach 2: Optimized Min Heap (Recommended)
 * Since arrays are sorted, the smallest pair is (nums1[0], nums2[0]).
 * Use a min-heap storing (sum, i, j) where:
 * i is index in nums1, j is index in nums2
 *
 * Start with (nums1[0] + nums2[0], 0, 0).
 * Each time we pop smallest sum: Add (nums1[i], nums2[j]) to result.
 * Push next candidates: (i+1, j) if not seen, (i, j+1) if not seen
 * Use a visited set to avoid duplicates.
 * 👉 Time complexity: O(k log k)
 * Much better!
 */
public class KPairsWithSmallestSum {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result; //base case

        PriorityQueue<int []> minHeap = new PriorityQueue<>((a, b)-> a[0] - b[0]);
        HashSet<String> visited = new HashSet<>();// avoid duplicates

        minHeap.offer(new int[]{nums1[0] + nums2[0], 0, 0});
        visited.add("0-0");

        while (k > 0 && !minHeap.isEmpty()){
            int curr[] = minHeap.poll();
            int i = curr[1];
            int j = curr[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;

            if(i+1 < nums1.length && !visited.contains((i+1)+"-"+j)){
                minHeap.offer(new int[]{nums1[i+1]+ nums2[j], i+1, j});
                visited.add((i+1)+"-"+j);
            }
            if(j+1 < nums2.length && !visited.contains(i+"-"+(j+1))){
                minHeap.offer(new int[]{nums1[i]+nums2[j+1], i, j+1});
                visited.add(i+"-"+(j+1));
            }
        }
        return result;
    }
}

/**
 Approach 1: Your Max Heap Idea

 Loop over all pairs (nums1[i], nums2[j]).

 Push into a max-heap by sum.

 If heap size > k → pop largest.

 Finally, heap contains k smallest pairs.

 👉 Time complexity: O(n*m * log k)
 ⚠️ This is too big when nums1 and nums2 are large. */
