package top150LC.Week7;

/**
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 *
 * Input: head = [1,2,3,4,5], left = 2, right = 4
 * Output: [1,4,3,2,5]
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0); // to keep track of head node
        dummy.next = head;

        ListNode prev = dummy;
        //now make prev pointer reach 1 step before left.
        for(int i = 1; i< left; i++){ // 1 indexed List
            prev = prev.next;
        }

        //now point curr pointer next to prev
        ListNode curr = prev.next;
        for(int i = 1; i<=right-left; i++){ // 1 indexed List
            ListNode temp = prev.next; //before changing prev ka next save it in temp
            prev.next = curr.next;
            curr.next = curr.next.next;
            prev.next.next = temp;
        }
        return dummy.next;//return dummy ka next which is the head of LL
    }
}

//TC = O(n)
//SC = O(1)
