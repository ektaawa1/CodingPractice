package otheTopicsExample;

import java.util.HashMap;

class DLL{
    DLL prev;
    DLL next;
    int key;
    int value;
    int freq;

    public DLL(int key, int value){
        this.key = key;
        this.value = value;
        this.freq = 1; // every new node has frequency = 1
    }
}
class DoublyLinkedList{
    DLL dummyHead;
    DLL dummyTail;
    int size;
    public DoublyLinkedList(){
        dummyHead = new DLL(0,0);
        dummyTail = new DLL(0,0);
        size = 0;
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    // same style as LRU addToHead
    public void addToHead(DLL node) {
        node.next = dummyHead.next;
        node.prev = dummyHead;
        dummyHead.next.prev = node;
        dummyHead.next = node;
        size++;
    }
    // same style as LRU removeNode
    public void removeNode(DLL node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }
    // remove from tail (LFU eviction rule)
    public DLL removeTail() {
        if (size > 0) {
            DLL tailNode = dummyTail.prev;
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

    HashMap<Integer, DLL> cacheMap;  // key -> node
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
        DLL node = cacheMap.get(key);
        updateFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        // If key exists, update value and frequency
        if (cacheMap.containsKey(key)) {
            DLL node = cacheMap.get(key);
            node.value = value;
            updateFrequency(node);
            return;
        }

        // If over capacity → remove LFU node
        if(size == capacity){
            DoublyLinkedList minFreqList = freqMap.get(minFreq);
            DLL nodeToRemove = minFreqList.removeTail();
            cacheMap.remove(nodeToRemove.key);
            size--;
        }

        // Insert new node
        DLL newNode = new DLL(key, value);
        cacheMap.put(key, newNode);

        freqMap.putIfAbsent(1, new DoublyLinkedList());
        freqMap.get(1).addToHead(newNode);

        minFreq = 1; // reset minFreq for new node
        size++;
    }

    private void updateFrequency(DLL node) {
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
