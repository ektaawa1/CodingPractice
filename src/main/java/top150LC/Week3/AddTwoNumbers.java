package top150LC.Week3;

// 2. Add Two Numbers
// Linked List https://algo.monster/liteproblems/2
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        int carry = 0;
        //int sum = 0;
        while(l1 != null || l2 != null || carry != 0){
            int v1 = (l1!= null) ? l1.val : 0;
            int v2= (l2!=null) ? l2.val : 0;

            int sum = v1 + v2 + carry;
            carry = sum / 10; //gives the carry (1) for the next iteration
            curr.next = new ListNode(sum % 10); //gives the digit to place at the current node, 8+7 =15 so 15%10 = 5
            //15/10 = 1 which is the carry over
            curr = curr.next;


            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummy.next;
    }
    private ListNode reverse(ListNode l){
        return l;
    }
}

//Example-
/**
 * sum = 7
 * curr.next = new ListNode(7);  // curr.next points to new node 7
 * curr = curr.next;            // curr moves to node 7
 *
 * Next sum = 0
 * curr.next = new ListNode(0); // curr.next points to new node 0
 * curr = curr.next;            // curr moves to node 0
 *
 * Next sum = 8
 * curr.next = new ListNode(8); // curr.next points to new node 8
 * curr = curr.next;            // curr moves to node 8
 */

//| Metric    | Complexity                                  |
//| --------- | ------------------------------------------- |
//| **Time**  | O(max(m, n)) (m = l1 length, n = l2 length) |
//| **Space** | O(max(m, n)) — for result list              |
