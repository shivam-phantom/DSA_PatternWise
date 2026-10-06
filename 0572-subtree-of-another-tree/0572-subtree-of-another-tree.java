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
    final String EMPTY = "#";
    final String delim = "|";
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        List<String> sb = new ArrayList<>();
        dfs(root,sb);
        String str = delim + String.join(delim,sb);
        List<String> subSb = new ArrayList<>();
        dfs(subRoot,subSb);
        String subStr = delim + String.join(delim,subSb);
        return str.indexOf(subStr)>-1;
    }
    public void dfs(TreeNode node, List<String> sb ){
        
        if(node == null){
            sb.add(EMPTY);
            return;
        }
        sb.add(String.valueOf(node.val));
        dfs(node.left,sb);
        dfs(node.right,sb);
    }
}