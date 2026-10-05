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
        List<TreeNode> pList = new ArrayList<>();
        List<TreeNode> qList = new ArrayList<>();
        if (!findPath(root, pList, p) || !findPath(root, qList, q))
            return null;
        TreeNode lca = null;
        int n = Math.min(pList.size(), qList.size());
        for (int i = 0; i < n; i++) {
            if (pList.get(i) == qList.get(i))
                lca = pList.get(i);
            else
                break;
        }
        return lca;
    }
    public boolean findPath(TreeNode node, List<TreeNode> list, TreeNode target){
        if(node == null)
            return false;
        list.add(node);
        if(node.val == target.val)
            return true;
        if(findPath(node.left,list,target) || findPath(node.right,list,target) )
            return true;
        list.remove(list.size()-1);
        return false;
    }
}