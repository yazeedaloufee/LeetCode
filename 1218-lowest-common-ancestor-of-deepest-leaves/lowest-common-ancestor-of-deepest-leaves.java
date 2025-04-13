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
 public class Pair{
    TreeNode node; 
    int depth;
    Pair(int depth, TreeNode node) {
        this.depth = depth; 
        this.node = node;
    }

 }
class Solution {
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root, 0).node;
    }

    public Pair dfs(TreeNode root, int depth){
        if(root == null) return null;
        Pair left = dfs(root.left, depth + 1);
        Pair right = dfs(root.right, depth + 1);
        if(left != null && right != null){
            if(left.depth == right.depth) {
                return new Pair(right.depth,root);
            } else if (left.depth > right.depth){
                return left;
            }else {
                return right;
            }
        }
        if(left != null) {
          return left;  
        }
        if(right != null) {
          return right;  
        }
        return new Pair(depth, root);
    }
}