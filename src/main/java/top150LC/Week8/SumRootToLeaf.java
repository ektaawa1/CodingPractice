package top150LC.Week8;

/**
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 * Each root-to-leaf path in the tree represents a number.
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 * A leaf node is a node with no children.
 */

/**
 * Input: root = [1,2,3], Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 */
class TreeNodeY {
      int val;
    TreeNodeY left;
    TreeNodeY right;
    TreeNodeY() {}
    TreeNodeY(int val) { this.val = val; }
    TreeNodeY(int val, TreeNodeY left, TreeNodeY right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

public class SumRootToLeaf {
    public int sumNumbers(TreeNodeY root) {
        return dfs(root, 0);//25
    }
    private int dfs(TreeNodeY node, int sum){
        if(node == null){
            return 0;
        }
        sum = sum * 10 + node.val; // 1, 12, 13
        if(node.left == null && node.right == null){
            return sum;
        }
        return dfs(node.left, sum) + dfs(node.right, sum);//12+13 = 25
    }
}
// TC = O(n)
// SC = O(H) recursive stack
