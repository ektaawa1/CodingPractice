package top75LC.Week3;
//1161. Maximum Level Sum of a Binary Tree

import java.util.Deque;
import java.util.LinkedList;

/**
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 */
class TreeNodeZ {
      int val;
    TreeNodeZ left;
    TreeNodeZ right;
    TreeNodeZ() {}
    TreeNodeZ(int val) { this.val = val; }
    TreeNodeZ(int val, TreeNodeZ left, TreeNodeZ right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
public class MaxLevelSumBT {
    public int maxLevelSum(TreeNodeZ root) {
        int level = 1;
        int maxSum = Integer.MIN_VALUE;
        int currLevel = 1;
        Deque<TreeNodeZ> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            int levelSum = 0;

            for(int i = 0; i<size; i++){
                TreeNodeZ curr = queue.poll();
                levelSum += curr.val;

                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }

            if(levelSum > maxSum){
                maxSum = levelSum;
                level = currLevel;
            }

            currLevel += 1;
        }
        return level;
    }
}
/**
 * Input: root = [1,7,0,7,-8,null,null], Output: 2
 * Explanation:
 * Level 1 sum = 1.
 * Level 2 sum = 7 + 0 = 7.
 * Level 3 sum = 7 + -8 = -1.
 * So we return the level with the maximum sum which is level 2.
 */

//Time Complexity
//O(n) → Each node visited once.
//Space Complexity
//O(h) → Call stack in recursion (h = tree height).
//Worst case (skewed tree): O(n)
//Best case (balanced tree): O(log n)
