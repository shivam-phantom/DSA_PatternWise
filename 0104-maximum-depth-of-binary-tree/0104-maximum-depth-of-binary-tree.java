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
    int max =0;
    public int maxDepth(TreeNode root) {
        max= dfs(root);
        return max;
    }

    public int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int lh= dfs(node.left);
        int rh= dfs(node.right);
        
        max = Math.max(lh,rh);
        return 1+max;
    }
}