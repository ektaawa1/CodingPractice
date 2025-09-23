package otheTopicsExample.sortingAlgo;

import java.net.StandardSocketOptions;

/**
 * Bubble Sort- Stable Algo
 * Outer loop i → tracks how many elements are already sorted at the end.
 * Inner loop j → swaps adjacent elements if needed.
 * With each outer loop, the largest remaining element moves to its correct place at the end.
 * With each pass, the largest unsorted element “bubbles” to the end.
 * TC = O(n^2), SC = O(1)
 * Stable- Swaps adjacent elements → preserves order of equal elements
 */
public class BubbleSortAlgo {
    public static void bubbleSort(int arr[]){
        int len = arr.length;
        for(int i = 0; i<len-1; i++){
            for(int j = 0; j<len-1-i; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void bubbleSortAdaptive(int arr[]){
        int len = arr.length;
        boolean swapped;
        for(int i = 0; i<len-1; i++){
            swapped = false; // Reset flag for each pass
            for(int j = 0; j<len-1-i; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true; // Mark that we swapped
                }
            }
            // If no swaps, array is already sorted
            if(!swapped){
                System.out.println("Already Sorted...");
                break;
            }
        }
    }
    public static void main(String args[]){
        int[] arr = {5, 2, 9, 1, 5, 6};
        int[] arr1 = {1,2,3,4,5};
        bubbleSort(arr);
        bubbleSortAdaptive(arr1);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
/**
 * What is “Adaptive” Sorting?
 * Adaptive: A sorting algorithm is called adaptive if it takes advantage of existing order in the array.
 * Meaning: If the array is already sorted or nearly sorted, an adaptive algorithm runs faster than its worst-case complexity.
 * Bubble Sort in its basic form is NOT adaptive, because it always runs n-1 passes even if the array is already sorted.
 */

/**
 * Idea: If no swaps are made during a pass, the array is already sorted → we can stop early.
 * We can do this by adding a flag to check if any swaps happened in the current pass.
 * swapped flag makes it adaptive.
 * Best case time complexity becomes O(n) if the array is already sorted.
 * Worst case is still O(n²).
 */

