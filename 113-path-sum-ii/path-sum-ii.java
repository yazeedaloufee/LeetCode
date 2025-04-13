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
    List<List<Integer>> output; 
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        output = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<Integer>(), 0);
        return output;
    }
    public void dfs(TreeNode root, int targetSum, List<Integer> stack, int prevSum){
        if (root == null) return; 
        stack.add(root.val);
        int currentSum =prevSum+ root.val;
        if(root.left == null && root.right == null && targetSum == currentSum) {
            output.add(new ArrayList<>(stack));
        }
        dfs(root.right, targetSum, stack,currentSum);
        dfs(root.left, targetSum, stack,currentSum);
        stack.remove(stack.size() - 1);
    }
}