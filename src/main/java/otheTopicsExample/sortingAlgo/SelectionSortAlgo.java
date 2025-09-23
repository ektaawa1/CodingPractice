package otheTopicsExample.sortingAlgo;

/**
 * Selection Sort- Not Stable
 * TC = O(n²), SC = O(1)
 * How Selection Sort Works
 * Idea: Repeatedly select the minimum (or maximum) element from the unsorted part of the array and move it to the correct position.
 * It divides the array into two parts:
 * Sorted (left side)
 * Unsorted (right side)
 */
public class SelectionSortAlgo {
    public static void selectionSort(int[] arr){
        int len = arr.length;
        for(int i = 0; i<len-1; i++){
            // Assume the minimum is at the current position
            int minIndex = i;

            // Find the actual minimum element in unsorted part
            for(int j = i+1; j<len; j++){
                if(arr[j]< arr[minIndex]){
                    minIndex = j;
                }
            }
            // Swap the found minimum with the current element
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            //How to make it stable??
            // Instead of swapping, we "insert" min at position i
            //            int key = arr[minIndex]; // 1️⃣ Store the minimum value
            //            while (minIndex > i) { // 2️⃣ Shift all elements to the right
            //                arr[minIndex] = arr[minIndex - 1];
            //                minIndex--;
            //            }
            //            arr[i] = key;
        }
    }
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
/**
 * Example:
 * Unsorted array: [64, 25, 12, 22, 11]
 * Pass 1: Select min=11, swap with 64 → [11, 25, 12, 22, 64]
 * Pass 2: Select min=12, swap with 25 → [11, 12, 25, 22, 64]
 * Pass 3: Select min=22, swap with 25 → [11, 12, 22, 25, 64]
 * Pass 4: Select min=25, already in place
 * Pass 5: Done
 */

/**
 * Stable Approach Idea
 * Instead of swapping, we “insert” the minimum element at position i without disturbing the order of equal elements in between.
 * We do this by shifting all elements between i and minIndex one position to the right, then putting min at i.
 * Imagine i = 1, minIndex = 4
 * The elements from arr[i] to arr[minIndex-1] are shifted right by 1.
 * This creates a “hole” at index i where we can place the minimum.
 * This way, all elements between i and minIndex keep their original relative order, including duplicates.
 */

