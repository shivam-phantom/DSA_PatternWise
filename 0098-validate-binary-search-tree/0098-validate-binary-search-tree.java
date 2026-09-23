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
    Integer pre = null;
    boolean res = true;
    public boolean isValidBST(TreeNode root) {
        inOrder(root);
        return res;
    }
    public void inOrder(TreeNode root){
        if(root==null)
            return;
        inOrder(root.left);
        if(pre!=null){
            if(pre>=root.val){
                res=false;
                return;
            }
        }
        pre=root.val;
        inOrder(root.right);
    }
}