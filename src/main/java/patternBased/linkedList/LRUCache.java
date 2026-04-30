package patternBased.linkedList;

// 146. LRU Cache https://algo.monster/liteproblems/146

import java.util.HashMap;
import java.util.Map;

/**
 * Using Doubly Linked List & Hash Map
 */
class Node {
    int key, val;
    Node1 prev, next;
    Node(int k, int v) { this.key = k; this.val = v; }
}
class LRUCache {
    int capacity;
    Map<Integer, Node1> map = new HashMap<>();
    Node1 head = new Node1(0, 0);
    Node1 tail = new Node1(0, 0);
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node1 node = map.get(key);
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node1 node = map.get(key);
            node.val = value;
            moveToHead(node);//since it is most recently used
        } else {
            Node1 newNode = new Node1(key, value);
            map.put(key, newNode);
            addToHead(newNode); //since its a new node so directly move to Head
            if(map.size() > capacity){
                Node1 lruNode = tail.prev;
                removeNode(lruNode);
                map.remove(lruNode.key);
            }
        }
    }

    private void moveToHead(Node1 currNode){
        //Remove the node
        removeNode(currNode);
        //add the node to head
        addToHead(currNode);
    }
    private void removeNode(Node1 node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    // dummyHead->node1->dummyTail ===>  dummyHead->node->node1->dummyTail
    private void addToHead(Node1 node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

//TC = O(1) for all the functions
//SC = O(capacity)

// Explanation-
/**
 * We will be using HashMap and Doubly Linked List. Now while inserting the key & value pair, we will be checking if the pair is already present in
 *  the Cache or not. Also we will be checking if the Cache size == capacity, then while inserting the pair, then remove the least recently used node
 *  & insert the new pair right after the head. If the key is not present in the Cache then we will be returning -1. We will be using a left & a right
 *  pointer to denote the LRU node & the most recently used node respectively.
 *
 *  Through each step, the put and get methods dynamically adjust the order of the doubly-linked list
 *  to ensure the most recently used items are nearest to the head, and the least recently used are near
 *  the tail, ready to be evicted when the capacity is exceeded. The hash map provides constant-time access
 *  to the nodes in the list during these operations.
 */
