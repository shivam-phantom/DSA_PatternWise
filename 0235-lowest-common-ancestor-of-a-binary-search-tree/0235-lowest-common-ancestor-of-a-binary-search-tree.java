/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // return dfs(root,p,q);
        // TreeNode low = p.val > q.val?q:p;
        // TreeNode high = p.val > q.val?p:q;
        int high = Math.max(p.val,q.val);
        int low = Math.min(p.val,q.val);
        while(true){
            if(root.val>high)
                root=root.left;
            else if(root.val<low)
                root=root.right;
            else
                return root;
        }
    }
    // public TreeNode dfs(TreeNode node, TreeNode p, TreeNode q){
    //     if(node == null)
    //         return node;
    //     if(node == p || node == q)
    //         return node;
    //     if (p.left == q || p.right == q) return p;
    //     if (q.left == p || q.right == p) return q;
    //     TreeNode lca1 = dfs(node.left,p,q);
    //     TreeNode lca2 = dfs(node.right,p,q);
    //     if(lca1 != null && lca2 != null)
    //         return node;
    //     if(lca1!=null)
    //         return lca1;
    //     return lca2;
    // }
}