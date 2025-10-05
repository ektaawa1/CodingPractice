package top150LC.Week9;

import java.util.PriorityQueue;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        //Put all nodes into an array/list, sort them, and rebuild the linked list.
        //Time: O(N log N) where N = total number of nodes.
        //Space: O(N).

        //Optimized Solution: Using MinHeap
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b)-> a.val - b.val); //Lambda to write the comparator:
        for(ListNode n : lists){
            if(n != null){
                pq.offer(n); //adding head of each linked list
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(!pq.isEmpty()){
            ListNode node = pq.poll(); //smallest node as minHeap
            curr.next = node;
            curr = curr.next;
            if(node.next != null){ //to get the next nodes
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }
}
//MinHeap Approach: Time: O(N log k) → N = total nodes, heap operations log k
//Space: O(k) → priority queue size

//Divide & Conquer Approach:
//Time: O(N log k) → N
//Space: O(1)

//Example:
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]

//So 1st- 1,1,2 will be stored in minHeap
//smallest will be popped out i.e. 1 and 1.next is 4 so minHeap will be 1,2,4 and so on 2,3,4
// then 3,4,6 then 4,4,6 then 4,5,6
//ouput build will be 1->1->2->3->4->5->6

/**
 In Java, PriorityQueue needs to know how to compare elements.
 By default, PriorityQueue works as a min-heap, but only if the elements are comparable (e.g., integers).
 Here, we are storing ListNode objects, not integers.
 ListNode has no default comparison (it doesn’t implement Comparable).
 So, we must tell the heap how to compare two nodes.
 That’s what (a, b) -> a.val - b.val does:
 If a.val < b.val, it returns a negative → a comes before b.
 If a.val > b.val, it returns a positive → b comes before a.
 If equal → returns 0.
 So yes this ensures the smallest node value stays at the top of the heap.
 */
