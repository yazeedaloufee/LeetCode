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
    int output = 0;
    public int goodNodes(TreeNode root) {
        helper(root, Integer.MIN_VALUE);
        return output;
    }

    public void helper(TreeNode node, int max) {
        if(node == null) return;
        if(node.val >= max) {
            output++;
        }
        helper(node.left, Math.max(max, node.val));
        helper(node.right, Math.max(max, node.val));
    }
}