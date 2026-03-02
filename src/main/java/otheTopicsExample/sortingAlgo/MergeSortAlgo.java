package otheTopicsExample.sortingAlgo;

import java.util.Arrays;

/**
 * Merge Sort- Stable
 * TC = O(n log n), SC = O(n)
 */
public class MergeSortAlgo {
    // Main method to start the sorting process
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        int mid = n / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, n);

        mergeSort(left); // Recursively sort the left sub-array
        mergeSort(right); // Recursively sort the right sub-array

        merge(arr, left, right); // Merge the sorted halves
    }
    // Method to merge two sorted sub-arrays into the original array
    public static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Copy remaining elements of left[] if any
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // Copy remaining elements of right[] if any
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Example usage
    public static void main(String[] args) {
        int[] data = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array: " + Arrays.toString(data));
        mergeSort(data);
        System.out.println("Sorted array: " + Arrays.toString(data));
    }
}
