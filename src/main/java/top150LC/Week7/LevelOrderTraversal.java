package top150LC.Week7;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreNode {
      int val;
    TreNode left;
    TreNode right;
    TreNode() {}
    TreNode(int val) { this.val = val; }
    TreNode(int val, TreNode left, TreNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

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
    public List<List<Integer>> levelOrder1(TreNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreNode node, int level, List<List<Integer>> result) {
        if (node == null) return;

        // Create a new level list if it doesn't exist yet
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }

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
