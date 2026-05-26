package patternBased.linkedList;

// 146. LRU Cache https://algo.monster/liteproblems/146

import java.util.HashMap;
import java.util.Map;

/**
 * Using Doubly Linked List & Hash Map-Why????
 * We are using a hashmap (cache) to search for the node in O(1) time and
 * to track the most recent & least recent usage of the nodes, we are using a linked list,
 * especially a doubly linked list. Doubly linked list has next & prev reference that
 * will be helpful to easily shift and add the node in the front of the LL.
 * Similarly, in order to evict the node, we can easily remove a node by using the prev reference of the node.
 * This operation of adding and removing can be done in O(1) time by using a Doubly LL.
 * (Note- To remove a node from a Singly Linked List, you have to know the node right before it.
 * Finding that previous node requires an O(N) traversal from the head.)
 */
//Doubly LinkedList- bidirectional traversal | O(1) insert/delete | Slow Random Access- O(n)
    // a linear data structure where each element (node) contains a data field and two references: one pointing to the next node and another pointing to the previous node.
class Node {
    int key, val;
    Node prev, next;
    Node(int k, int v) { this.key = k; this.val = v; }
}
class LRUCache {
    int capacity;//or int size;
    Map<Integer, Node> cacheMap = new HashMap<>();//polymorphism
    //It’s a best practice for decoupled code. By coding to the Map interface, I keep my implementation flexible. If I later realize I need the cache to be thread-safe, I can change the right side to ConcurrentHashMap without having to change any of the method signatures or logic that uses the map variable
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    public LRUCache(int capacity) {
        this.capacity = capacity; //or size = capacity
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)) return -1;
        Node node = cacheMap.get(key);
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            Node node = cacheMap.get(key);
            node.val = value;
            moveToHead(node);//since it is most recently used
        } else {
            Node newNode = new Node(key, value);
            cacheMap.put(key, newNode);
            addToHead(newNode); //since its a new node so directly move to Head
            if(cacheMap.size() > capacity){//evict the LRU node
                Node lruNode = tail.prev;
                removeNode(lruNode);
                cacheMap.remove(lruNode.key);
            }
        }
    }

    private void moveToHead(Node currNode){
        //Remove the node
        removeNode(currNode);
        //add the node to head
        addToHead(currNode);
    }
    // dummyHead->node1->node->dummyTail  ===>  dummyHead->node1->dummyTail
    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    // dummyHead->node1->dummyTail ===>  dummyHead->node->node1->dummyTail
    private void addToHead(Node node){
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
 *  the Cache or not.
 *  Also we will be checking if the Cache size == capacity, then while inserting the pair, then remove the least recently used node
 *  & insert the new pair right after the head. If the key is not present in the Cache then we will be returning -1. We will be using a left & a right
 *  pointer to denote the LRU node & the most recently used node respectively.
 *
 *  Through each step, the put and get methods dynamically adjust the order of the doubly-linked list
 *  to ensure the most recently used items are nearest to the head, and the least recently used are near
 *  the tail, ready to be evicted when the capacity is exceeded. The hash map provides constant-time access
 *  to the nodes in the list during these operations.
 */
