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
    List<TreeNode> res;
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while(cur!=null){
            if(cur.left!=null){
                TreeNode pre = cur.left;

                while(pre.right!=null){
                    pre=pre.right;
                }
                pre.right=cur.right;
                cur.right=cur.left;
                cur.left=null;
            }
            cur=cur.right;
        }
        // if(root==null)
        //     return ;
        // res = new ArrayList<>();
        // dfs(root,false);
        
        // for(int i=0;i<res.size()-1;i++){
        //     TreeNode cur = res.get(i);
        //     cur.left=null;
        //     cur.right=res.get(i+1);
        // }
        // TreeNode last = res.get(res.size()-1);
        // last.left=null;
        // last.right=null;
    }
    public void dfs(TreeNode node,boolean isLeft){
        if(node == null)
            return;
        //fetch right
        //take left and add it to the right
        //if left is null go for right
        //
        // TreeNode left = node.left;
        // TreeNode right = node.right;
        // node.right=left;
        res.add(node);
        dfs(node.left,true);

        dfs(node.right,false);
    }
}