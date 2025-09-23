package top150LC.Week8;

/**
 * Input: head = [1,2,3,3,4,4,5], Output: [1,2,5]
 *
 * Input: head = [1,1,1,2,3], Output: [2,3]
 */
class ListNode1 {
      int val;
    ListNode1 next;
    ListNode1() {}
    ListNode1(int val) { this.val = val; }
    ListNode1(int val, ListNode1 next) { this.val = val; this.next = next; }
  }

public class RemoveDuplicatesFromSortedList {
    public ListNode1 deleteDuplicates(ListNode1 head) {
        ListNode1 dummy = new ListNode1(0);
        dummy.next = head;
        ListNode1 prev = dummy;
        ListNode1 curr = head;
//        // base condition
//        if(head == null || head.next == null){
//            return head;
//        }
        //iterate through the LL
        while(curr != null){ //this is taking care of the base condition
            //check for duplicate values
            while(curr.next != null && curr.val == curr.next.val){
                curr = curr.next; // keep moving to next node
            }
            if(prev.next == curr){//if no duplicates
                prev = prev.next;
            } else { //if duplicate, skip it
                prev.next = curr.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
// TC = O(n)
// SC = O(1)
