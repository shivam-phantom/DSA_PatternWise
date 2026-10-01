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
    int[] preorder;
    int preIndex = 0;
    Map<Integer,Integer> inMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i=0;i<inorder.length;i++)
            inMap.put(inorder[i],i);
        // TreeNode root = dfs(0,preorder.length-1,0,inorder.length-1);
        TreeNode root = dfs_op(0,inorder.length-1);
        return root;
    }

    public TreeNode dfs(int preL,int preR,int inL,int inR){
        if(preL> preR || inL > inR)
            return null;
        int val = preorder[preL];
        TreeNode root = new TreeNode(val);
        int idx = inMap.get(val);
        int leftSize = idx-inL;
        root.left = dfs (preL+1,preL+leftSize,inL,idx-1);
        root.right = dfs (preL+leftSize+1,preR,idx+1,inR);

        return root;
    }

    public TreeNode dfs_op(int left,int right){
        if(left>right)
            return null;
        int val = preorder[preIndex++];
        TreeNode root = new TreeNode(val);
        int mid = inMap.get(val);
        root.left= dfs_op(left,mid-1);
        root.right=dfs_op(mid+1,right);
        return root;
    }
}