package otheTopicsExample;
import java.util.LinkedList;
import java.util.Queue;

//226. Invert Binary Tree

//Given the root of a binary tree, invert the tree, and return its root.
  class TreeNode1 {
      int val;
      TreeNode1 left;
      TreeNode1 right;
      TreeNode1() {}
      TreeNode1(int val) { this.val = val; }
      TreeNode1(int val, TreeNode1 left, TreeNode1 right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

//mirroring a binary tree
//TC = O(n) → Each node is processed once.
//
//SC = O(w) → Max width of tree (worst case O(n) if tree is very wide).
//Using BFS Approach
public class InvertBinaryTree {
    public TreeNode1 invertTree(TreeNode1 root) {
        if (root == null) return null;

        Queue<TreeNode1> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode1 current = queue.poll();

            // Swap left & right children
            TreeNode1 temp = current.left;
            current.left = current.right;
            current.right = temp;

            // Add children to queue AFTER swap
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }

        return root;
    }
    //Recursion:
    //TC = O(n) → Each node is visited once.
    //
    //SC = O(h) → Height of recursion stack (h = height of tree, worst-case O(n) if skewed,
    // O(log n) if balanced).
    public TreeNode1 invertTree1(TreeNode1 root) {
        // Base case: if node is null, nothing to invert
        if (root == null) return null;

        // Swap left and right
        TreeNode1 temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert the left and right subtrees
        invertTree1(root.left);
        invertTree1(root.right);

        // Return the current node (with swapped children)
        return root;
    }
}

/**
 * Why swapping doesn’t cancel out in recursion
 * Because: You swap once at the current node. Then you recurse into the (already swapped) children
 — you’re inverting their subtrees, not swapping back the parent’s swap.
 * Why queue doesn’t mix up left/right
 * Queue is just a storage structure — it stores nodes in the order you insert them.
 * When you dequeue and process a node later, the node already knows which child is left and
 * which is right because you swapped before enqueuing.
 */

/**
 * A Deque (double-ended queue) Interface
 * allows adding or removing elements from both ends and can work as either a FIFO queue or a LIFO stack.
 *
 * Supports FIFO and LIFO : Can function as a queue (FIFO) or a stack (LIFO).
 * No Capacity Restriction (for most implementations) : Classes like ArrayDeque grow automatically as needed.
 * More Versatile than Queue : Provides extra methods like addFirst(), addLast(), peekFirst(), peekLast().
 * Efficient Insert/Remove at Both Ends : Constant-time performance for add/remove operations at either end in most implementations.
 */
