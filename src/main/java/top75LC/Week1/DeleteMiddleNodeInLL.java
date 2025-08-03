package top75LC.Week1;

/**
 * You are given the head of a singly linked list.
 * Delete the middle node, and return the head of the modified list.
 * If the list has only 1 node, return null.
 * The middle is defined as ⌊n / 2⌋-th node (0-indexed), where n is the number of nodes.
 */
class ListNodeD {
      int val;
    ListNodeD next;
    ListNodeD() {}
    ListNodeD(int val) { this.val = val; }
    ListNodeD(int val, ListNodeD next) { this.val = val; this.next = next; }
  }

  // Using Slow & Fast Pointer approach.

/**
 * Once the while loop ends, slow pointer will be at the Middle of a Singly Linked List.
 * Then we can remove the middle node by assigning- prev.next to slow.next
 */
public class DeleteMiddleNodeInLL {
    public ListNodeD deleteMiddle(ListNodeD head) {
        ListNodeD prev = null;
        ListNodeD slow = head;
        ListNodeD fast = head;
        if(head == null || head.next == null){
            return null;
        }
        while(fast!= null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return head;
    }
}
//Time: O(n)
//
//Space: O(1) – no extra space used
