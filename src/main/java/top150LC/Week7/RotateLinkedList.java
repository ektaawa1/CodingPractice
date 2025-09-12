package top150LC.Week7;

public class RotateLinkedList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        int len = 1;
        ListNode tail = head;
        //calculate total length of the given LL
        while( tail.next != null){
            tail = tail.next; //update tail
            len++;
        }

        if(k>=len){ // It ensures that k is always in the range [0, len-1]
            k = k%len;
        }

        if( k == 0){
            return head;
        }
        ListNode newTail = head;
        for(int  i = 1; i < len-k; i++){
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;

        newTail.next = null;
        tail.next = head;

        return newHead;
    }
    // Circle Approach
    public ListNode rotateRightCircle(ListNode head, int k) {
        if(head == null || head.next == null || k == 0){
            return head;
        }
        int len = 1;
        ListNode tail = head;
        //calculate total length of the given LL
        while( tail.next != null){
            tail = tail.next; //update tail
            len++;
        }

        if(k>=len){ // It ensures that k is always in the range [0, len-1]
            k = k%len;
        }

        if( k == 0){
            return head; //no rotation needed
        }

        //Only 1 pass to get length, 1 pass to newTail → O(n)
        tail.next = head; // make LL as circular


        ListNode newTail = head;
        for(int  i = 1; i < len-k; i++){
            newTail = newTail.next;
        }
        // Break circle & set new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
    // Rotate left by K steps
    public ListNode rotateLeft(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        // Step 1: find length and tail
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }

        // Step 2: normalize k
        k = k % len;
        if (k == 0) return head;

        // Step 3: find new tail (k-1) and new head (k)
        ListNode newTail = head;
        for (int i = 1; i < k; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;

        // Step 4: break and rewire
        newTail.next = null;
        tail.next = head;

        return newHead;
    }
}
//Best Time Complexity: O(n) (cannot be improved).
//Best Space Complexity: O(1) (already achieved — no new nodes created).

/**
 * Can we do better than O(n) time? No — and here’s why:
 * To rotate a linked list by k, you need to know where the new head and new tail are.
 * That requires knowing the length (n) of the list.
 * The only way to know the length is to traverse the list once.
 * Therefore, O(n) is the lower bound — you cannot do better than O(n).
 * So any valid solution will have at least O(n) time complexity.
 */

//Circular Linked List Trick
/**
 * Steps:
 * Find length n and  compute k = k % n
 * connect tail → head (making it circular).
 * Find the new tail at (n - k - 1) steps from head.
 * Break the circle right after new tail → that becomes new head.
 */

//Universal Solution??
/**
 * Idea 💡
 * Let rotateRight flag be true → rotate right
 * If false → rotate left
 * Compute effective rotation index in terms of right rotation:
 * EffectiveRightK = right ? k : n - k
 * public ListNode rotateList(ListNode head, int k, boolean rotateRight) {....}
 */
