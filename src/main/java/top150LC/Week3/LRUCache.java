package org.Week3;

// 146. LRU Cache https://algo.monster/liteproblems/146

import java.util.HashMap;

/**
 * Using Doubly Linked List & Hash Map
 */
class DoublyLinkedListNode {
    int key;
    int value;
    DoublyLinkedListNode next;
    DoublyLinkedListNode prev;

    //constructor
    public DoublyLinkedListNode(int key, int value){
        this.key = key;
        this.value = value;
    }
}
public class LRUCache {
    private int capacity;
    private int size;
    private HashMap<Integer, DoublyLinkedListNode> cacheMap;
    private DoublyLinkedListNode head;
    private DoublyLinkedListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cacheMap = new HashMap<>();
        this.head = new DoublyLinkedListNode(0,0);
        this.tail = new DoublyLinkedListNode(0,0);
    }

    public int get(int key) {
        if (!cacheMap.containsKey(key)){
            return -1;
        }
        DoublyLinkedListNode node = cacheMap.get(key);
        // now make it MRU node by making it point to head
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)){
            DoublyLinkedListNode node = cacheMap.get(key);
            node.value = value;
            // now make it MRU node by making it point to head
            moveToHead(node);
        } else {
            DoublyLinkedListNode newNode = new DoublyLinkedListNode(key, value);
            cacheMap.put(key, newNode);
            // now make it MRU node by making it point to head
            moveToHead(newNode);
            size++;
            if(size > capacity) {
                //remove the LRU node i.e which is nearest to the Tail
                DoublyLinkedListNode tailNode = removeTailNode();
                // also remove from hashmap
                cacheMap.remove(tailNode.key);
                size--;
            }

        }
    }

    private void moveToHead(DoublyLinkedListNode node) {
        removeNode(node);
        addToHead(node);
    }

    // Removes and returns the tail node (least recently used node)
    private DoublyLinkedListNode removeTailNode() {
        DoublyLinkedListNode node = tail.prev;
        removeNode(node);
        return node;
    }

    private void removeNode(DoublyLinkedListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(DoublyLinkedListNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
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
