package patternBased.binarySearch;
// 4. Median of Two Sorted Arrays

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 * The overall run time complexity should be O(log (m+n)). (which means its asking for binary search)
 */
public class MedianOfTwoSortedArrays {
    //BruteForce
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] merged = new int[n + m];
        int i = 0, j = 0, k = 0;

        while(i < n && j < m) {
            if(nums1[i] < nums2[j]) merged[k++] = nums1[i++];
            else merged[k++] = nums2[j++];
        }
        while(i < n) merged[k++] = nums1[i++];
        while(j < m) merged[k++] = nums2[j++];

        int len = n + m;
        if(len % 2 == 1) return merged[len/2];
        else return (merged[len/2 -1] + merged[len/2]) / 2.0;
    }
    //Optimized- Binary Search
}
