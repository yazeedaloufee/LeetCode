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
    int sum;
    public TreeNode bstToGst(TreeNode root) {
        sum = 0;
        sum = dfs(root);
        System.out.println("sum = " + 
        sum);
        calcNumber(root);
        return root;
    }
    public void calcNumber(TreeNode root) {
        if ( root == null) return;
        calcNumber(root.left);
        int temp = root.val;
        root.val = sum;
        sum -= temp;
        calcNumber(root.right);
        return;

    }
    public int dfs(TreeNode root) {
        if(root == null) return 0; 

        int left = dfs(root.left);
        int right = dfs(root.right);
        return root.val + left + right;
    }
}