package top150LC.Week7;

public class
ReverseLinkedListII {
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
