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
    Map<String,Integer> map = new HashMap<>();
    List<TreeNode> list = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return list;
    }
    public String dfs(TreeNode node){
        if(node == null){
            return "#";
        }
        String left = dfs(node.left);
        String right = dfs(node.right);
        String res = node.val+"," + left + ","+right;
        map.put(res,map.getOrDefault(res,0)+1);
        if(map.get(res)==2)
            list.add(node);
        return res;
    }
}