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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList();
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> output = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if(i == size-1) {
                    output.add(temp.val);
                }
                if(temp.left != null) {
                    queue.add(temp.left);
                }
                if(temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
        return output;        
    }
}