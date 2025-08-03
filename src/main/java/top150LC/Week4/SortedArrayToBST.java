package org.Week4;

class TreeNodeA {
      int val;
      TreeNodeA left;
      TreeNodeA right;
      TreeNodeA() {}
      TreeNodeA(int val) { this.val = val; }
      TreeNodeA(int val, TreeNodeA left, TreeNodeA right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class SortedArrayToBST {
    public TreeNodeA sortedArrayToBST(int[] nums) {
        return createBST(nums,0,nums.length-1);
    }

    private TreeNodeA createBST(int[] nums, int l, int r) {
        //base case
        if(l>r){
            return null;
        }

        int mid = l+ (r-l)/2;
        TreeNodeA root = new TreeNodeA(nums[mid]);
        root.left = createBST(nums, l, mid-1);
        root.right = createBST(nums, mid+1, r);
        return root;
    }
}

//A node is height-balanced if |leftHeight - rightHeight| <= 1
/**
 *         5
 *        /
 *       3
 *      /
 *     1
 *    /
 *   0
 *   Now the left subtree has height = 3, right = 0
 * → Difference = 3 → ❌ Not balanced
 */

/**
 *         5          → root
 *        / \
 *       3   8        → 3 has a left child (1), 8 has no children
 *      /
 *     1
 * Node 3 has height = 2 (3 → 1)
 * Node 8 has height = 1 (leaf node)
 * Difference at root 5 = |2 - 1| = 1 → ✅ Okay
 */

/**
 *     4
 *    / \
 *   2   6
 *  / \ / \
 * 1  3 5  7
 *
 * Node 4 has:
 * Left side height = 2 (4 → 2 → 1)
 * Right side height = 2 (4 → 6 → 5)
 * ✅ Difference = 0 → Balanced
 *
 * Node 2 has:
 * Left height = 1 (2 → 1)
 * Right height = 1 (2 → 3)
 * ✅ Difference = 0 → Balanced
 *
 * ✔ All nodes follow the rule → Height-balanced
 */

//Time: O(n) — every element is visited once
//
//Space: O(log n) — for the recursive call stack (height of the tree)
