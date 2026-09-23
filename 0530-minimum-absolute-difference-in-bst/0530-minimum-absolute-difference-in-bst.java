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
    int min = Integer.MAX_VALUE;
    int pre = -1;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);

        return min;
    }

    void inOrder(TreeNode root){
        if(root == null)
            return;
        inOrder(root.left);

        if(pre!=-1){
            // min = Math.min(min, Math.abs(pre-root.val));
            min = Math.min(min, root.val - pre);
        }


        pre=root.val;
        inOrder(root.right);
    }

}