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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);        
    }

    private boolean isValid(TreeNode root, long left, long right) {
        if(root == null) return true;
        if(root.val <= left || root.val >= right) return false;

        return isValid(root.left,left, Math.min(right, root.val)) && isValid(root.right, Math.max(left, root.val), right);

    }
}