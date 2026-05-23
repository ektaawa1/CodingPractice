package patternBased.trees;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//199. Binary Tree Right Side View
// BFS approach https://algo.monster/liteproblems/199
public class BTRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null){
            return rightList;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int qSize = queue.size();
            int rightVal=0;
            for(int i = 0; i<qSize; i++){
                TreeNode currNode = queue.poll();
                rightVal = currNode.val; //overwriting the value of node to right node value always
                if(currNode.left != null) queue.offer(currNode.left);
                if(currNode.right != null) queue.offer(currNode.right);
            }
            rightList.add(rightVal);
        }
        return rightList;
    }
    //DFS Approach
    public List<Integer> rightSideViewDFS(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }

    private void dfs(TreeNode node, int level, List<Integer> result) {
        if (node == null) return;

        // first time we reach this level — this is the rightmost node
        // because we traverse RIGHT subtree before LEFT
        if (level == result.size()) {
            result.add(node.val);
        }

        dfs(node.right, level + 1, result); // RIGHT first — critical
        dfs(node.left, level + 1, result);
    }
    //I traverse right child before left — so the first node I encounter at each depth is always
    // the rightmost visible one.
}
// Time: O(n)
// Space: O(n)
/**
 * Another approach-
 * while (!queue.isEmpty()) {
 *         int size = queue.size();
 *
 *         for (int i = 0; i < size; i++) {
 *             TreeNode node = queue.poll();
 *             if (i == size - 1) result.add(node.val); // last node of each level
 *             if (node.left != null) queue.offer(node.left);
 *             if (node.right != null) queue.offer(node.right);
 *         }
 *     }
 *     return result;
 */

/**
 * Dry Run-
 *
 * Tree:
 *         1
 *        / \
 *       2   3
 *        \   \
 *         5   4
 * Initial: queue = [1], result = []
 *
 * --- Iteration 1 ---
 * size = 1
 *   i=0: poll 1, i == size-1 (0==0) → result = [1]
 *        push left(2), push right(3)
 * queue = [2, 3]
 *
 * --- Iteration 2 ---
 * size = 2
 *   i=0: poll 2, i != size-1 → skip
 *        push right(5)  [no left]
 *   i=1: poll 3, i == size-1 (1==1) → result = [1, 3]
 *        push right(4)  [no left]
 * queue = [5, 4]
 *
 * --- Iteration 3 ---
 * size = 2
 *   i=0: poll 5, i != size-1 → skip
 *        no children
 *   i=1: poll 4, i == size-1 (1==1) → result = [1, 3, 4]
 *        no children
 * queue = []
 *
 * Final result: [1, 3, 4]
 */

/**
 * Tree:
 *         1
 *        /
 *       2
 *        \
 *         5
 * Output: [1, 2, 5]
 * If we only go right from node 1 — we hit null immediately. We'd miss node 2 and 5 entirely.
 * The left subtree sometimes contains the only visible node at a level when there's no right child.
 * So the logic is:
 * Go right first → captures rightmost node at each level
 * Go left after → handles cases where left subtree is deeper than right
 * The level == result.size() condition naturally blocks left-side duplicates.
 * Left only contributes when right didn't reach that depth first.
 */
