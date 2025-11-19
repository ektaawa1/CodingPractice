package top75LC.Week1;


class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class ReverseLL {
    // 3 pointers approach, TC = O(n), SC = O(1)
    // Input: 1-->2-->3-->4-->5-->null
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode curr = head;

        while(curr != null){
            next = curr.next;//before breaking the connection
            //now break the connection and make it point to left side to reverse
            curr.next = prev;
            //now update prev & curr values
            prev = curr;
            curr = next;
        }
        return prev;
    }
    // Simple test run
    public static void main(String[] args) {
        // Create sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> null
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5, null)))));

        ReverseLL obj = new ReverseLL();
        ListNode reversed = obj.reverseList(head);

        // Print reversed list
        while (reversed != null) {
            System.out.print(reversed.val + " ");
            reversed = reversed.next;
        }
        // Expected Output: 5 4 3 2 1
    }
}

//C  N
//1->2->3->4->5->NULL
//P  C  N
//            P   C

//Time → O(n) (each node visited once)
//Space → O(1) (no extra data structures)
