package prampPract;

/**
 * You are given an array of characters arr that consists of sequences of characters
 * separated by space characters. Each space-delimited sequence of characters defines a word.
 * Implement a function reverseWords that reverses the order of the words in the array in the most
 * efficient manner.
 */

/**
 * Step-by-Step Efficient Approach
 * Reverse the entire array → this puts the words in reversed order, but each word itself is reversed too.
 * Reverse each word individually → this fixes the order inside each word.
 */
public class ReverseASentence {
    static char[] reverseWords(char[] arr) { //arr: [p,e,r,f,e,c,t, ,m,a,k,e,s, ,p,r,a,c,t,i,c,e]
        // your code goes here
        reverse(arr, 0, arr.length-1); // arr: [e,c,i,t,c,a,r,p, ,s,e,k,a,m, ,t,c,e,f,r,e,p]

        int start = 0;
        for(int i = 0; i <= arr.length; i++){ // i == arr.length as a boundary signal
            //At that moment, we pretend there’s an “imaginary space” after the last word to trigger the reverse one final time.
            if( i == arr.length || arr[i] == ' '){
                reverse(arr, start, i-1);
                start = i + 1;
            }
        }
        return arr; //arr:[p,r,a,c,t,i,c,e, ,m,a,k,e,s, ,p,e,r,f,e,c,t]
    }
    private static void reverse(char[] arr, int i, int j){
        while(i < j){ //to avoid swap the middle element with itself, 1<->7 2<->6..4<->4
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
    public static void main(String[] args) {
        // debug your code below
        char[] arr = { 'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' };
        char[] result = reverseWords(arr);

        System.out.print("Reversed words array: ");
        for (char ch : result) {
            System.out.print(ch);
        }
        System.out.println();
    }
}
//TC = O(n)
//SC = O(1)
/**
 * input:  arr = [ 'p', 'e', 'r', 'f', 'e', 'c', 't', '  ',
 *                 'm', 'a', 'k', 'e', 's', '  ',
 *                 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e' ]
 *
 * output: [ 'p', 'r', 'a', 'c', 't', 'i', 'c', 'e', '  ',
 *           'm', 'a', 'k', 'e', 's', '  ',
 *           'p', 'e', 'r', 'f', 'e', 'c', 't' ]
 */
