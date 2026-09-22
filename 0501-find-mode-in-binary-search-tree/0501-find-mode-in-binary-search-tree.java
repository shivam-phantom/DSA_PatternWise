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
    HashMap<Integer,Integer> map = new HashMap<>();
    // PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
    List<Integer> resList = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        int max = Integer.MIN_VALUE;
        countFreq(root);
        for(int i : map.values()){
            max = Math.max(max,i);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()==max){
                resList.add(entry.getKey());
            }
        }
        
        
        // int[] res = pq.poll();
        // resList.add(res[0]);
        // while(!pq.isEmpty() && pq.peek()[1]==res[1]){
        //     int[] temp = pq.poll();
        //     resList.add(temp[0]);
        // }
        int[] res = new int[resList.size()];
        for(int i =0;i<resList.size();i++){
            res[i]=resList.get(i);
        }
        return res;
    }
    void countFreq(TreeNode root){
        if(root!=null){
            countFreq(root.left);
            
            map.put(root.val,map.getOrDefault(root.val,0)+1);
            // pq.offer(new int[]{root.val,map.get(root.val)});
            countFreq(root.right);
        }
    }
}