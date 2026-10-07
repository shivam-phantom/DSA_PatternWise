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
        // List<String> sb = new ArrayList<>();
        // dfs(root,sb);
        // String str = delim + String.join(delim,sb);
        // List<String> subSb = new ArrayList<>();
        // dfs(subRoot,subSb);
        // String subStr = delim + String.join(delim,subSb);
        // return str.indexOf(subStr)>-1;
        if(root == null && subRoot == null)
            return true;
        if(root== null || subRoot == null)
            return false;
        if(isIdentical(root,subRoot))
            return true;
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
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
    public boolean isIdentical(TreeNode s, TreeNode t){
        if(s==null && t == null)
            return true;
        if(s==null || t==null)
            return false;
       
        if(s.val != t.val)
            return false;
            
        return isIdentical(s.left,t.left) && isIdentical(s.right,t.right);   
    }
    // public boolean isSubTree(TreeNode s, TreeNode t){
    //     // if(s==null && t== null)
    //     //     return true;
    //     // if(s==null || t==null)
    //     //     return false;
    //     if(isIdentical(s,t))
    //         return true;
    //     return isSubTree(s.left,t) || isSubTree(s.right,t);
    // }
}