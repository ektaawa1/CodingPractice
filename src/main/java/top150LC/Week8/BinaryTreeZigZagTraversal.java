package top150LC.Week8;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * BFS Algo Approach-
 * 1st level → left to right
 * 2nd level → right to left
 * 3rd level → left to right
 * …and so on.
 */
public class BinaryTreeZigZagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> finalList = new ArrayList<>();
        if (root == null) return finalList;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            LinkedList<Integer> l1 = new LinkedList<>();
            for(int i = 0; i< size; i++){
                TreeNode curr = queue.poll();
                if(leftToRight){
                    l1.add(curr.val);//adds at last or //queue.pollFirst()
                }else {
                    //insert at index 0 each time → newest node goes to front i.e. index 0 → reverses order.
                    l1.add(0, curr.val);// adds at front or //queue.pollLast()
                }
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            finalList.add(l1);
            leftToRight = !leftToRight;//flip directions
        }
        return finalList;
    }
}
//Time Complexity: O(n) (visit each node once)
//Space Complexity: O(n) (queue + result storage)
/**
 * Example:
 *        3
 *      /   \
 *     9     20
 *          /  \
 *         15   7
 */
/**
 * Level 1 (leftToRight = true)
 * Queue: [3]
 * Take 3. leftToRight == true → l1.add(3) → l1 = [3].
 * Add children (9,20) to queue.
 * FinalList = [[3]]
 *
 * Level 2 (leftToRight = false)
 * Queue: [9,20]
 * i=0: Take 9. Since leftToRight == false, do l1.add(0,9) → l1 = [9].
 * i=1: Take 20. Again leftToRight == false, do l1.add(0,20) → l1 = [20,9].
 * Add children (15,7).
 * FinalList = [[3], [20,9]]
 *
 * Level 3 (leftToRight = true)
 * Queue: [15,7]
 * i=0: Take 15. leftToRight == true, so l1.add(15) → l1 = [15].
 * i=1: Take 7. l1.add(7) → l1 = [15,7].
 * FinalList = [[3], [20,9], [15,7]]
 */
