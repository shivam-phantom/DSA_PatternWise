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
    Map<Integer,Integer> depthMap = new HashMap<>();
    Map<Integer,List<int[]>> levelMaxes = new HashMap<>();
    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = queries.length;
        int[] res = new int[n];
        getHeight(root,0);
        for(int i =0;i<n;i++){
            int val = queries[i];
            int d = depthMap.get(val);
            List<int[]> tops = levelMaxes.get(d);
            if(tops.get(0)[1]==val){
                if(tops.size()>1){
                    res[i] = d + tops.get(1)[0];
                } else{
                    res[i] = d-1;
                }
            } else{
                res[i]= d + tops.get(0)[0];
            }
        }
        return res;
    }
    public int getHeight(TreeNode node, int depth){
        if(node == null)
            return -1;
        depthMap.put(node.val,depth);
        int lh = getHeight(node.left,1+depth);
        int rh = getHeight(node.right,1+depth);
        int currH = 1 + Math.max(lh,rh);
        levelMaxes.putIfAbsent(depth,new ArrayList<>());
        List<int[]> tops = levelMaxes.get(depth);
        tops.add(new int[]{currH,node.val});
        tops.sort((a,b)->b[0]-a[0]);
        if(tops.size()>2)
            tops.remove(2);
        return currH;
    }
}