package patternBased.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class MaxStack {
    //Use Doubly LinkedList
    class Node {
        int val;
        Node prev, next;
        Node(int v) { val = v; }
    }

    TreeMap<Integer, List<Node>> map;
    Node head, tail;

    public MaxStack() {
        map = new TreeMap<>();
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    private void add(Node node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void push(int x) {
        Node node = new Node(x);
        add(node);

        map.putIfAbsent(x, new ArrayList<>());
        map.get(x).add(node);
    }

    public int pop() {Node node = tail.prev;
        remove(node);

        List<Node> list = map.get(node.val);
        list.remove(list.size() - 1);
        if (list.isEmpty()) map.remove(node.val);

        return node.val;

    }

    public int top() {
        return tail.prev.val;
    }

    public int peekMax() {
        return map.lastKey();
    }

    public int popMax() {
        int max = map.lastKey();
        List<Node> list = map.get(max);
        Node node = list.remove(list.size() - 1);

        remove(node);
        if (list.isEmpty()) map.remove(max);

        return max;
    }
}
//TC = O(1)

/**
 * popMax() — remove the maximum element (not necessarily on top)
 * This breaks normal stack behavior.
 * Because stack only allows:
 * Remove top
 * But max may be buried deep
 *
 * Design stack with:
 * push(x), pop(), top(), peekMax(), popMax()
 */

/**
 * | Operation | Time     |
 * | --------- | -------- |
 * | push      | O(log n) |
 * | pop       | O(log n) |
 * | top       | O(1)     |
 * | peekMax   | O(log n) |
 * | popMax    | O(log n) |
 */

