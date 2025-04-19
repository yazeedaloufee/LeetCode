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
    int count;
    public int averageOfSubtree(TreeNode root) {
        count = 0; 
        dfs(root);
        return count;
    }

    public int[] dfs ( TreeNode root) {
        if(root == null) return new int[2];

        int[] left = dfs(root.left);
        int[] right = dfs(root.right); 
        int totalSum = root.val + left[0] + right[0];
        int totalNodes = 1 + left[1] + right[1];

        if (totalSum/totalNodes == root.val){
            count++;
        }
        return new int[]{totalSum, totalNodes };
    }
}