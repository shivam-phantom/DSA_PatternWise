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
    int count = 0;
    int maxCount = 0;
    int nodeCount =0;
    Integer pre = null;
    int [] modes;
    int idx=0;
    public int[] findMode(TreeNode root) {
        // HashMap<Integer,Integer> map = new HashMap<>();
        // int[] maxCount = {0};
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        // List<Integer> resList = new ArrayList<>();
        // int max = Integer.MIN_VALUE;
        // countFreq(root,map,maxCount,resList);
        // for(int i : map.values()){
        //     max = Math.max(max,i);
        // }
        // for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        //     if(entry.getValue()==max){
        //         resList.add(entry.getKey());
        //     }
        // }
        
        
        // int[] res = pq.poll();
        // resList.add(res[0]);
        // while(!pq.isEmpty() && pq.peek()[1]==res[1]){
        //     int[] temp = pq.poll();
        //     resList.add(temp[0]);
        // }
        // int[] res = new int[resList.size()];
        // for(int i =0;i<resList.size();i++){
        //     res[i]=resList.get(i);
        // }
        inOrder(root,false);
        modes = new int[nodeCount];
        inOrder(root,true);
        return modes;
    }
    void countFreq(TreeNode root,HashMap<Integer,Integer> map,int[] maxCount,List<Integer> resList){
        if(root==null)
            return;
        // if(root!=null){
            countFreq(root.left,map,maxCount,resList);
            int count = map.getOrDefault(root.val,0)+1;
            map.put(root.val,count);
            if(count>maxCount[0]){
                maxCount[0]=count;
                resList.clear();
                resList.add(root.val);
            } else if(count == maxCount[0]){
                resList.add(root.val);
            }
            // pq.offer(new int[]{root.val,map.get(root.val)});
            countFreq(root.right,map,maxCount,resList);
        // }
    }
    // int count = 0;
    // int maxCount = 0;
    // int nodeCount =0;
    // Integer pre = null;
    // int [] modes;
    // int idx=0;
    void inOrder(TreeNode root,boolean collect){
        if(root == null)
            return;
        inOrder(root.left,collect);

        count = (pre != null && pre == root.val)?count+1:1;

        if(count>maxCount){
            maxCount=count;
            if(collect){
                modes[0]=root.val;
                idx=1;
            } else{
                nodeCount=1;
            }
        } else if(count==maxCount ){
            if(collect)
                modes[idx++]=root.val;
            else
                nodeCount++;
        }
        pre=root.val;
        inOrder(root.right,collect);
    }
}