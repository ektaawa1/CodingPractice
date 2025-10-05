package top75LC.Week3;

/**
 * 450. Delete Node in a BST
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 * Basically, the deletion can be divided into two stages:
 * Search for a node to remove.
 * If the node is found, delete the node.
 */
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
public class DeleteNodeInBST {
    public TreNode deleteNode(TreNode root, int key) {
        if(root == null){
            return null;
        }
        if(key<root.val){ //to search in the left side of the tree
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){ //to search in the right side of the tree
            root.right = deleteNode(root.right, key);
        } else { //if key is equal to root.val
            if(root.left == null){// if left side is not there
                return root.right;
            } else if(root.right == null){ //if right side is not there
                return root.left;
            } else { //if both the sides are present i.e., left child & right child
                TreNode currNode = root.right; //finding the min value in the right side of the tree
                while(currNode.left != null){ //right subtree will have min value in its left side
                    currNode = currNode.left;
                }
                root.val = currNode.val;//overwriting root value to min value
                root.right = deleteNode(root.right, root.val); //Now our root has the successor’s value — but                             the successor node itself still exists in the right subtree.
//If we don’t remove it, we’ll end up with a duplicate value in the BST, which breaks the rules.
            }
        }
        return root;
    }
}
//Time & Space Complexity
//Time: O(h) (height of tree) → worst case O(n), average O(log n)
//Space: O(h) recursion stack
/**
 * Dry Run: delete 5
 *        5
 *       / \
 *      3   6
 *         / \
 *        4   7
 *
 * Node 5 has two children.
 * Find min in right subtree → 6 → min is 6’s left child = 4.
 *
 * Copy 4 into node 5:
 *     4
 *    / \
 *   3   6
 *      / \
 *     4   7
 *
 * Now there are two 4s (duplicate).
 * Call deleteNode(root.right, 4) to remove that duplicate from the right subtree:
 *     4
 *    / \
 *   3   6
 *        \
 *         7
 * Result: BST property preserved ✅
 */

/** Max from Left Subtree:
 * else {
 *                 // Case 3: Two children -> use inorder predecessor (max from left)
 *                 TreeNode maxNode = findMax(root.left);
 *                 root.val = maxNode.val; // Replace with predecessor
 *                 root.left = deleteNode(root.left, maxNode.val); // Delete predecessor
 *             }
 *         }
 *         return root;
 *     }
 *
 *     private TreeNode findMax(TreeNode node) {
 *         while (node.right != null) {
 *             node = node.right;
 *         }
 *         return node;
 *     }
 */
