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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> output = new ArrayList<>();

        if(root == null) return output;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> inner = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                inner.add(temp.val);
                if(temp.left != null)
                queue.add(temp.left);
                if(temp.right != null)
                queue.add(temp.right);
            }
            output.add(inner);
        }
        return output;
        
    }
}