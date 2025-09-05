package top150LC.Week7;

  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  //2 approaches- Single Pass using 2 pointers approach- fast & slow pointers
// Two pass approach-
public class DeleteNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;

        for(int i =0; i <= n; i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next; //return head
    }
        //one for length calculation, another for deletion
      public ListNode removeNthFromEnd1(ListNode head, int n) {
          // Step 1: Find length
          int length = 0;
          ListNode curr = head;
          while (curr != null) {
              length++;
              curr = curr.next;
          }

          // Step 2: Find the index to remove (from start)
          int target = length - n;

          // Step 3: Dummy node for easier edge cases
          ListNode dummy = new ListNode(0);
          dummy.next = head;
          curr = dummy;

          // Step 4: Traverse to (target)th node
          for (int i = 0; i < target; i++) {
              curr = curr.next;
          }

          // Step 5: Remove node
          curr.next = curr.next.next;

          return dummy.next;
      }
}
//TC = O(L) where L is the length of the list
//SC = O(1)

/**
 * It helps us handle edge cases smoothly, especially when the head itself needs to be removed.
 * Example:
 * head = [1,2,3], n = 3 → we need to remove the 1st node (head).
 * output = [2,3]
 */
