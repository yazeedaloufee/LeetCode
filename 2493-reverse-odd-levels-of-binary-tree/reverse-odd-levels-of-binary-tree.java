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
    public TreeNode reverseOddLevels(TreeNode root) {
        Deque<TreeNode> q = new ArrayDeque<>();

        q.add(root); 
        int level = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            TreeNode[] floor = new TreeNode[size];
            for(int i = 0; i < size; i++ ){
                floor[i] = q.poll();
                if(floor[i].left != null)
                q.add(floor[i].left);
                if(floor[i].right != null)
                q.add(floor[i].right);
            }
            if(level %2 == 1){
                int l =0, r = size - 1; 
                while(l < r) {
                    int temp = floor[l].val;
                    floor[l].val = floor[r].val;
                    floor[r].val = temp;
                    l++;
                    r--;
                }
            }
            level++;
        }
        return root;
        
    }
}