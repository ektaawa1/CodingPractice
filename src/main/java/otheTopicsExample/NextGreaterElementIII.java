package otheTopicsExample;

/**
 * Example:
 * n = 12        → output = 21
 * n = 21        → output = -1  (no greater arrangement)
 * n = 230241    → output = 230412
 * n = 12443322  → output = 13222344
 */
public class NextGreaterElementIII {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);//"12"
        int arr[] = new int[s.length()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.charAt(i) - '0';//'1'-'0' = 1
        }//arr[] = [1,2]

        // Step 1: find dip from right
        int i = arr.length - 2;// starts our pointer at the second-to-last digit (the 4) in n= 230241
        while (i >= 0 && arr[i] >= arr[i + 1]) {//Check 4 >= 1 (True, move left), Check 2 >= 4 (False, stop!)
            i--;
        }
        // no dip → already largest arrangement
        if (i < 0) return -1;

        // Step 2: find swap candidate from right
        int j = arr.length - 1;//last element
        //Check 1 <= 2 (True, move left), Check 4 <= 2 (False, stop!), Our swap candidate is at index 4 (the number 4).
        while (arr[j] <= arr[i]) {//scans leftward, looking for a number strictly greater than our dip (2).
            j--;
        }

        // Step 3: swap: arr = [2, 3, 0, 4, 2, 1]
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        // Step 4: reverse right portion- Minimizes the right half of the array- 2,1 to 1,2
        reverse(arr, i + 1, arr.length - 1);//arr = [2, 3, 0, 4, 1, 2]

        // Step 5: convert int array back to number
        long result = 0;//to avoid integer overflow
        for (int k = 0; k < arr.length; k++) {
            result = result * 10 + arr[k];//230412
        }
        return result > Integer.MAX_VALUE ? -1 : (int) result;
    }

    private void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}

/**
 * 1. FIND DIP    → scan right to left, first digit < its right neighbor
 * 2. FIND SWAP   → rightmost digit that is > dip digit
 * 3. SWAP THEM   → dip gets replaced by next bigger digit
 * 4. REVERSE     → sort right portion ascending for smallest increase
 */
