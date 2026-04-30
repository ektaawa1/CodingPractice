package patternBased.linkedList;

import java.util.HashMap;

class Node1 {
    Node1 prev;
    Node1 next;
    int key;
    int value;
    int freq;

    public Node1(int key, int value){
        this.key = key;
        this.value = value;
        this.freq = 1; // every new node has frequency = 1
    }
}
class DoublyLinkedList{
    Node1 head;
    Node1 tail;
    int size;
    public DoublyLinkedList(){
        head = new Node1(0,0);
        tail = new Node1(0,0);
        size = 0;
        head.next = tail;
        tail.prev = head;
    }
    // same style as LRU addToHead
    public void addToHead(Node1 node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
    }
    // same style as LRU removeNode
    public void removeNode(Node1 node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }
    // remove from tail (LFU eviction rule)
    public Node1 removeTail() {
        if (size > 0) {
            Node1 tailNode = tail.prev;
            removeNode(tailNode);
            return tailNode;
        }
        return null;
    }
}
public class LFUCache {
    int capacity;
    int size;
    int minFreq;

    HashMap<Integer, Node1> cacheMap;  // key -> node
    HashMap<Integer, DoublyLinkedList> freqMap; // freq -> DLL list

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
        cacheMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        if(!cacheMap.containsKey(key)){
            return -1;
        }
        Node1 node = cacheMap.get(key);
        updateFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        // If key exists, update value and frequency
        if (cacheMap.containsKey(key)) {
            Node1 node = cacheMap.get(key);
            node.value = value;
            updateFrequency(node);
            return;
        }

        // If over capacity → remove LFU node
        if(size == capacity){
            DoublyLinkedList minFreqList = freqMap.get(minFreq);
            Node1 nodeToRemove = minFreqList.removeTail();
            cacheMap.remove(nodeToRemove.key);
            size--;
        }

        // Insert new node
        Node1 newNode = new Node1(key, value);
        cacheMap.put(key, newNode);

        freqMap.putIfAbsent(1, new DoublyLinkedList());
        freqMap.get(1).addToHead(newNode);

        minFreq = 1; // reset minFreq for new node
        size++;
    }

    private void updateFrequency(Node1 node) {
        int oldFreq = node.freq;
        int newFreq = oldFreq+1;
        node.freq = newFreq;

        DoublyLinkedList oldList = freqMap.get(oldFreq);
        oldList.removeNode(node);
         if(oldFreq == minFreq && oldList.size == 0){
             minFreq++;
         }
         freqMap.putIfAbsent(newFreq,new DoublyLinkedList());
         freqMap.get(newFreq).addToHead(node);
    }
}
