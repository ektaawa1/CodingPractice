package top150LC.Week8;

/**
 * We can split the list into two separate linked lists:
 * before list → nodes < x
 * after list → nodes >= x
 * At the end, connect before → after.
 */

class ListNodeA {
      int val;
    ListNodeA next;
    ListNodeA() {}
    ListNodeA(int val) { this.val = val; }
    ListNodeA(int val, ListNodeA next) { this.val = val; this.next = next; }
  }
public class PartitionList {
    public ListNodeA partition(ListNodeA head, int x) {
        ListNodeA dummy1 = new ListNodeA(0);//for nodes lesser than x
        ListNodeA dummy2 = new ListNodeA(0); //for nodes greater or equal to x
        ListNodeA node1 = dummy1;
        ListNodeA node2 = dummy2;

        while(head != null){
            if(head.val < x){ //append to node1
                node1.next = head;
                node1 = node1.next;
            } else { //append to node2
                node2.next = head;
                node2 = node2.next;
            }
            head = head.next;
        }
        node2.next = null; //make tail point to null, prevents potential cycle if original list had nodes rearranged.
        node1.next = dummy2.next; //join the head to the tail

        return dummy1.next; //return the head
    }
}

// TC = O(n), SC = O(1).
