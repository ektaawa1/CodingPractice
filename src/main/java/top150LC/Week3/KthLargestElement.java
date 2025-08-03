package org.Week3;
// ???????????????????????????????          DO IT AGAIN ???????????????????????????????
import java.util.PriorityQueue;

// https://algo.monster/liteproblems/215
// 215. Kth Largest Element in an Array
// Using Quick sort
public class KthLargestElement {
    //Quick Select Approach ()- QuickSelect is similar to QuickSort —
    // but instead of sorting the full array, it only partially sorts to find the Kth largest/smallest.
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k; // To find the Kth largest, get (n-k)th smallest
        return quickSelect(nums, 0, nums.length - 1, target);
    }

    private int quickSelect(int[] nums, int left, int right, int k) {
        int pivot = nums[right]; // choosing pivot as the rightmost element
        int start = left; // start pointer

        for (int i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                swap(nums, i, start);
                start++;
            }
        }
        swap(nums, start, right); // place pivot in correct sorted position

        if (start > k) {
            return quickSelect(nums, left, start - 1, k); // search left half
        } else if (start < k) {
            return quickSelect(nums, start + 1, right, k); // search right half
        } else {
            return nums[start]; // found the kth element
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // using MinHeap Approach (Recommended)
    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i = 0; i<nums.length; i++){
            minHeap.offer(nums[i]);
            if(minHeap.size()>k){ // remove the smallest (top) element if size exceeds k
                minHeap.poll();//to keep only k largest elements
            }
        }
        return minHeap.peek(); // kth largest element
    }
}
//
// Explanation- MinHeap
/**
 * MinHeap keeps smallest on top,
 * After inserting all numbers — top is the kth largest element.
 * //TC = O(n log k) Each insertion/removal takes log k, total n times
 * //SC = O(k) as size of heap is k
 *
 * Process each number:
 * Add 3: Heap = [3] (size < 2)
 * Add 2: Heap = [2, 3] (size == 2) ✔️
 * Add 1: Heap = [1, 3, 2] (size > 2, remove 1) ➔ Heap = [2, 3]
 * Add 5: Heap = [2, 3, 5] (size > 2, remove 2) ➔ Heap = [3, 5]
 * Add 6: Heap = [3, 5, 6] (size > 2, remove 3) ➔ Heap = [5, 6]
 * Add 4: Heap = [4, 6, 5] (size > 2, remove 4) ➔ Heap = [5, 6]
 */

/**
 * Quick Select-
 * //Avg case time complexity = O(n)
 * //Worst case TC = O(n^2)
 * Space Complexity: O(1) (in-place)
 * Recursion stack: O(log n) average, O(n) worst
 */
