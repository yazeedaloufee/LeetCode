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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(isSameTree(root, subRoot)) return true;
        boolean output = false;
        if(root.left != null){
            output = isSubtree(root.left, subRoot);
        }
        
        if(root.right != null&& output == false){
            output = isSubtree(root.right, subRoot);
        }
        return output;
    }


    public boolean isSameTree(TreeNode first, TreeNode second) {
        if ( first == null && second == null) return true;
        if(first == null || second == null || second.val != first.val) return false;

        return isSameTree(first.left, second.left) && isSameTree(first.right, second.right); 
    }
}