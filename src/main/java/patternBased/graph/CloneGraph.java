package patternBased.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
//DFS Approach
public class CloneGraph {
    //Graph can have cycles → must use visited map
    private HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        if(map.containsKey(node)){
            return map.get(node);
        }
        Node clone = new Node(node.val);
        map.put(node, clone);

        for(Node neighbor : node.neighbors){
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }
    //BFS Approach
}

/**
 * 1 -- 2
 * |    |
 * 4 -- 3
 * Node 1’s neighbors: [2,4]
 * Node 2’s neighbors: [1,3]
 * Node 3’s neighbors: [2,4]
 * Node 4’s neighbors: [1,3]
 */
/**
 * | Metric | Value                                        |
 * | ------ | -------------------------------------------- |
 * | Time   | O(V + E) → traverse every node and edge once |
 * | Space  | O(V) → map + recursion stack (DFS)           |
 */
