package top150LC.Week3;

// 146. LRU Cache https://algo.monster/liteproblems/146

import java.util.HashMap;

/**
 * Using Doubly Linked List & Hash Map
 */
class DoublyLL{
    DoublyLL next;
    DoublyLL prev;
    int key;
    int val;
    public DoublyLL(int key, int value){ //constructor
        this.key = key;
        this.val = value;
    }
}
class LRUCache {
    int capacity;
    int size;
    DoublyLL dummyHead;
    DoublyLL dummyTail;
    HashMap<Integer, DoublyLL> cacheMap;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.cacheMap = new HashMap<>();
        this.dummyHead = new DoublyLL(0,0);
        this.dummyTail = new DoublyLL(0,0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        if(!cacheMap.containsKey(key)){
            return -1;
        }
        DoublyLL node = cacheMap.get(key);
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            DoublyLL node = cacheMap.get(key);
            node.val = value;
            moveToHead(node);//since it is most recently used
        } else {
            DoublyLL newNode = new DoublyLL(key, value);
            cacheMap.put(key, newNode);
            addToHead(newNode); //since its a new node so directly move to Head
            size++;
            if(size > capacity){
                DoublyLL lruNode = dummyTail.prev;
                removeNode(lruNode);
                cacheMap.remove(lruNode.key);
                size--;
            }
        }

    }
    // head->node->currNode->tail ====> head->node->tail
    // ===============================> head->currNode->node->tail
    private void moveToHead(DoublyLL currNode){
        //Remove the node
        removeNode(currNode);
        //add the node to head
        addToHead(currNode);
    }
    private void removeNode(DoublyLL node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    // dummyHead->node1->dummyTail ===>  dummyHead->node->node1->dummyTail
    private void addToHead(DoublyLL node){
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next.prev = node;
        dummyHead.next = node;
    }
}

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
