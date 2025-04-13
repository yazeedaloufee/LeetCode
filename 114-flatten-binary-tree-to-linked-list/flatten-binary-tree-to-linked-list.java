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
    public void flatten(TreeNode root) {
        TreeNode current = new TreeNode();
        preOrder(root, current);
        root = current.right;
        return ;
    }

    public void preOrder(TreeNode root, TreeNode origin) {
        if(root == null)  return; 
        while(origin.right != null) {
            origin = origin.right;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = null;
        root.right = null;
        origin.right = root;
        preOrder(left, origin.right);
        preOrder(right, origin.right);

    }
}