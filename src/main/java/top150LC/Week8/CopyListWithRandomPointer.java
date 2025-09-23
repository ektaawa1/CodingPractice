package top150LC.Week8;

import java.util.HashMap;

// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map = new HashMap<>(); //old node -->new node
        if(head == null) return null;

        Node curr = head;
        //Step1: Create new nodes without any connections
        while(curr != null){
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }
        //Step2: Set connections i.e., set next & random pointers
        curr = head;
        while(curr != null){
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
}
//TC = O(n)
//SC = O(n)

