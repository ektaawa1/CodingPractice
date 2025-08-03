package org.Week4;

//https://www.youtube.com/watch?v=HNUwChtLkHo

public class KthLargestUsingQuickSelect {
    public int findKthLargest(int[] nums, int k) {
        int left = 1;
        int right = nums.length-1;
        int pivotIndex = 0;
        partition_algo(nums, left,right);
        return 0;
    }

    private void partition_algo(int[] nums, int left, int right) {
    }
}
