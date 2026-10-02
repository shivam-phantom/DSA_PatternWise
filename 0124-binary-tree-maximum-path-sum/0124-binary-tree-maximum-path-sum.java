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
    int max =Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int res = dfs(root);
        return Math.max(max,res);
    }
    int dfs(TreeNode node){
        if(node == null)
            return 0;
        int leftSum = Math.max(0,dfs(node.left));
        int rightSum = Math.max(0,dfs(node.right));
        int sum = node.val + leftSum + rightSum;
        // if(leftSum>0)
        //     sum+= leftSum;
        // if(rightSum>0)
        //     sum+= rightSum;
        max = Math.max(sum,max);
        // if(leftSum<0 && rightSum<0)
        //     return node.val;
        return node.val+Math.max(leftSum,rightSum);
    }
}