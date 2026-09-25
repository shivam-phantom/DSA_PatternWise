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
    String small = null;
    public String smallestFromLeaf(TreeNode root) {
        dfs(root,new StringBuilder());
        return small;
    }

    public void dfs(TreeNode node, StringBuilder sb){
        //use backTracking with stringBuilder
        if(node == null)
            return;
        sb.append((char)('a' + node.val));
        
        if(node.left == null && node.right == null){
            //comapre with small;
            String cur = new StringBuilder(sb).reverse().toString();
            if(small == null)
                small = cur;
            else
                small = small.compareTo(cur)>0?cur:small;
        }

        dfs(node.left,sb);
        // sb.setLength(sb.length()-1);
        dfs(node.right,sb);
        sb.setLength(sb.length()-1);
    }
}