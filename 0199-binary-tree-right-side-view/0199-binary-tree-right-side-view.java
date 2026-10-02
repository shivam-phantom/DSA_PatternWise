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
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        // Queue<TreeNode> bfs = new LinkedList<>();
        // if(root == null)
        //     return res;
        // bfs.offer(root);
        
        // while(!bfs.isEmpty()){
        //     int size = bfs.size();
        //     for(int i=0;i<size;i++){
        //         TreeNode cur = bfs.poll();
        //         if(i==size-1)
        //             res.add(cur.val);
        //         if(cur.left!=null)
        //             bfs.offer(cur.left);
        //         if(cur.right!=null)
        //             bfs.offer(cur.right);
        //     } 
        // }
        
        return res;
    }
    public void dfs(TreeNode node, int depth){
        if(node == null)
            return ;
        if(res.size() == depth)
            res.add(node.val);
        dfs(node.right,depth+1);
        dfs(node.left,depth+1);
    }
}