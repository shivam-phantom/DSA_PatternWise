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
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res= new ArrayList<>();
        // preOrder(root,"");
        preOrder(root,new StringBuilder());
        return res;
    }

    // public void preOrder(TreeNode node, String cur){
    public void preOrder(TreeNode node, StringBuilder cur){
        if(node == null)
            return;
        int len = cur.length();
        cur.append(node.val);
        // if(cur.length()>0)
        //     cur = cur + "->"+node.val;
        // else
        //     cur = String.valueOf(node.val);

        if(node.left == null && node.right==null){
            res.add(cur.toString());
            // return;
        } else {
            cur.append("->");
        }
        
        preOrder(node.left,cur);
        preOrder(node.right,cur);
        // res.add(cur.toString());
        cur.setLength(len);
    }
}