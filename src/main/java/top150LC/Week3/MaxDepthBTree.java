package top150LC.Week3;


import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthBTree {
    //Using DFS approach for recursion
    public int maxDepth(TreeNode root) {
        //base condition no node = depth 0
        if(root == null){
            return 0;
        }
        int leftDepth = maxDepth(root.left); // Find left subtree depth
        int rightDepth = maxDepth(root.right); // Find right subtree depth
        return Math.max(leftDepth, rightDepth) + 1; // Max depth + this root node
    }
    //iterative solution using BFS approach
    /**
     * Use a queue.
     * Process nodes level by level.
     * For each level, increase the depth counter by 1.
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) return 0; // Edge case: empty tree
        //Deque<TreeNode> q = new ArrayDeque<>();
        Queue<TreeNode> queue = new LinkedList<>();// to process nodes level by level
        queue.offer(root); // queue.offer(x) is the same as queue.add(x) — inserts an element at the end of the queue.
        int depth = 0;

        while (!queue.isEmpty()) {
            //Count how many nodes exist at that level (levelSize).
            int levelSize = queue.size(); // number of nodes at current level


            // process all nodes at this level
            //
            //Remove (poll) the node from the queue.
            //
            //Add its left and right children (if they exist) into the queue.
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            depth++; // one level deeper After processing a level → increment depth by 1.
        }

        return depth;
    }

}
// Step by step explanation
/**
 * Initial Setup:
 * Queue: [3]
 * Depth: 0
 *
 * 🔹 Step 1: Process Level 1
 * levelSize = 1 (only node 3)
 * Process node 3:
 * Add 9 and 20 to queue.
 * Queue after this level: [9, 20]
 * Increase depth → depth = 1
 *
 * 🔹 Step 2: Process Level 2
 * levelSize = 2 (nodes 9, 20)
 * Process node 9: no children → nothing added.
 * Process node 20: add 15, 7 to queue.
 * Queue after this level: [15, 7]
 * Increase depth → depth = 2
 *
 * 🔹 Step 3: Process Level 3
 * levelSize = 2 (nodes 15, 7)
 * Process node 15: no children.
 * Process node 7: no children.
 * Queue after this level: [] (empty)
 * Increase depth → depth = 3
 *
 * 🔹 End:
 * Queue is empty.
 *
 * Max Depth = 3
 */

/**
 * | Method                       | TC   | SC                       |
 * | ---------------------------- | ---- | ------------------------ |
 * | DFS (recursive)              | O(n) | O(h) (stack depth)       |
 * | BFS (iterative, level-order) | O(n) | O(w) (max width of tree) |
 */
