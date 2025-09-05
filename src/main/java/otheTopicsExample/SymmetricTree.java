package otheTopicsExample;

import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }

 //BFS or Recursion
public class SymmetricTree {
     public boolean isSymmetric1(TreeNode root) {
         if (root == null) return true;

         Queue<TreeNode> q = new LinkedList<>();
         q.offer(root.left);
         q.offer(root.right);

         while (!q.isEmpty()) {
             TreeNode t1 = q.poll();
             TreeNode t2 = q.poll();

             if (t1 == null && t2 == null) continue;
             if (t1 == null || t2 == null) return false;
             if (t1.val != t2.val) return false;

             // Add in mirror order
             q.offer(t1.left);
             q.offer(t2.right);
             q.offer(t1.right);
             q.offer(t2.left);
         }

         return true;
     }
     public boolean isSymmetric(TreeNode root) {
         if(root == null){
             return true;
         }
         return isMirror(root.left, root.right);
     }
     public boolean isMirror(TreeNode n1, TreeNode n2){
         if(n1 == null && n2 == null) return true;
         if(n1 == null || n2 == null) return false;
         //mirror logic
         //
         return (n1.val == n2.val) && isMirror(n1.left, n2.right) && isMirror(n1.right, n2.left);
     }
}
/**
 * Mirror symmetry means:
 * t1.left ↔ t2.right (outer pair)
 * t1.right ↔ t2.left (inner pair)
 * If we compared t1.left to t2.left, we’d just be checking that both left sides match —
 * but that’s not symmetry, that’s equality of structure.
 */

/**
 * return (t1.val == t2.val)
 *        && isMirror(t1.left, t2.right)  // outer match
 *        && isMirror(t1.right, t2.left); // inner match
 * First check values.
 *
 * Then check the “mirror” children:
 * Outer left of t1 ↔ outer right of t2
 * Inner right of t1 ↔ inner left of t2
 * That’s the mirror effect.
 */
//Time Complexity:O(n) → Every node is visited once.
//
//Space Complexity:O(h) for recursion stack (recursive version) or O(w) for
// queue (iterative BFS), where h = height, w = max width of tree.