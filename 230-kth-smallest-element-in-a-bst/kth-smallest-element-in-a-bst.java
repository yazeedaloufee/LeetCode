/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        Deque<TreeNode>queue = new ArrayDeque<>();
        int counter = 0;
        // queue.push(root);
        TreeNode curr = root;
        while(curr != null || !queue.isEmpty()) {
            while(curr != null) {
                queue.push(curr);
                curr = curr.left;
            }
            curr = queue.pop();
            counter++;
            if (counter == k) {
                return curr.val;
            }
            curr=curr.right;


        }


        return curr.val;
    }
}