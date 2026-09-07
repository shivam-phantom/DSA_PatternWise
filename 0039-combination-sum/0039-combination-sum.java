class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public void findcombo(int start, List<Integer> cur, int[] candidates, int target){
        if(target==0){
            res.add(new ArrayList<>(cur));
            return;
        }
        if(start==candidates.length)
            return;
        
        if(candidates[start]<=target){
            cur.add(candidates[start]);
            findcombo(start,cur,candidates,target-candidates[start]);
            cur.remove(cur.size()-1);
        }
        findcombo(start+1,cur,candidates,target);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        findcombo(0,new ArrayList<Integer>(),candidates,target);
        return res;
    }
}