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
    public List<Integer> rightSideView(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> bfs = new LinkedList<>();
        if(root == null)
            return res;
        bfs.offer(root);
        
        while(!bfs.isEmpty()){
            int size = bfs.size();
            for(int i=0;i<size;i++){
                TreeNode cur = bfs.poll();
                if(i==size-1)
                    res.add(cur.val);
                if(cur.left!=null)
                    bfs.offer(cur.left);
                if(cur.right!=null)
                    bfs.offer(cur.right);
            } 
        }
        
        return res;
    }
}