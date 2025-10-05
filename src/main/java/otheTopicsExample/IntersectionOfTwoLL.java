package otheTopicsExample;

/**
 * Given the heads of two singly linked-lists headA and headB, return the node at which the
 * two lists intersect. If the two linked lists have no intersection at all, return null.
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Intersected at '8'
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
public class IntersectionOfTwoLL {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        while(lenA > lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenB > lenA){
            headB = headB.next;
            lenB--;
        }

        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
    private int getLength(ListNode node){
        int count = 0;
        while(node != null){
            count++;
            node = node.next;
        }
        return count;
    }
    //Solution2: Two Pointer Switching (Elegant Solution)
    //Use two pointers a and b, starting at headA and headB.
    //Traverse forward.
    //When a pointer reaches the end, switch it to the other list’s head.
    //If there’s an intersection, they’ll meet at the intersection node.
    //If no intersection, both will eventually become null.
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            if(a == null){
                a = headB;
            } else {
                a = a.next;
            }

            if(b == null) {
                b = headA;
            }else {
                b = b.next;
            }
        }

        return a;
    }
}

/**
 * Time: O(m + n) (compute lengths + traversal)
 * Space: O(1)
 *
 * Example Dry Run
 * List A: 1 → 9 → 1 → 2 → 4 (length = 5)
 * List B: 3 → 2 → 4 (length = 3)
 * Intersection at 2.
 *
 * Length difference = 5 - 3 = 2.
 * → Move pointer of A forward 2 steps: headA = 1→2→4.
 * → Now both lists have 3 nodes left.
 *
 * Traverse both together:
 * Compare 1 vs 3 → not same
 * Compare 2 vs 2 → same → intersection found.
 *
 * Approach: Length Alignment
 * The idea is: First, find the lengths of both linked lists.
 * Move the pointer of the longer list ahead by the length difference, so that both pointers are equally far from the end.
 * Then move both pointers together step by step.
 * The first common node is the intersection. If no intersection, both become null.
 */

/**
 * Solution 2:
 * Example Dry Run
 *
 * List A: 1 → 9 → 1 → 2 → 4
 * List B: 3 → 2 → 4
 * Intersection at node with value 2.
 *
 * a traverses 1→9→1→2→4→null→3→2…
 * b traverses 3→2→4→null→1→9→1→2…
 * They meet at node 2.
 */
