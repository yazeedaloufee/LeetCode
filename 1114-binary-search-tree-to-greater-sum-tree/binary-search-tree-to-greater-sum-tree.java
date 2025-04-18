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
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        gen(root);
        return root;
    }

    public void gen(TreeNode root){
        if(root==null){
            return;
        }
        gen(root.right);
        root.val = sum+root.val;
        sum = root.val;
        gen(root.left);
        return ;
    }
}