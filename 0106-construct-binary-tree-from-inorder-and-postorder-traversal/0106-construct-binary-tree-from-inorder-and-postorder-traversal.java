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
    int rootIdx ;
    Map<Integer,Integer> inMap;
    int[] postorder;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder=postorder;
        int n = inorder.length;
        rootIdx = n-1;
        inMap = new HashMap<>();
        for(int i=0;i<n;i++){
            inMap.put(inorder[i],i);
        }
        TreeNode root = dfs(0,n-1);
        return root;
    }
    public TreeNode dfs(int left,int right){
        if(left>right )
            return null;
        int val = postorder[rootIdx--];
        TreeNode root = new TreeNode(val);
        int mid = inMap.get(val);
        
        root.right = dfs(mid+1,right);
        root.left = dfs(left,mid-1);
        return root;
    }
}