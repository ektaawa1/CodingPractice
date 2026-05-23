package patternBased.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    // BFS Algo
    public List<List<Integer>> levelOrder(TreNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i<size; i++){
                TreNode curr = queue.poll();
                level.add(curr.val);

                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            result.add(level);
        }
        return result;
    }
    // DFS Approach
    // The key difference from BFS is space — DFS uses O(h) stack space vs O(n) for BFS queue.
    public List<List<Integer>> levelOrder1(TreNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreNode node, int level, List<List<Integer>> result) {
        if (node == null) return;

        //if visiting this level for first time, create a new list
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        // add current node to its level
        result.get(level).add(node.val);

        dfs(node.left, level + 1, result);
        dfs(node.right, level + 1, result);
    }
    //Time Complexity: O(n) → each node visited once.
    //Space Complexity:
    //O(h) recursion stack (where h = tree height).  Plus O(n) result storage.  Worst case (skewed tree): O(n) stack depth.
}

//Time Complexity: O(n) → every node is processed once.
//
//Space Complexity: O(n) → queue holds at most one level of nodes.
