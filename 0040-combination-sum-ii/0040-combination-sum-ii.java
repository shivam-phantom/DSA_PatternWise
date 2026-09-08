class Solution {
    // public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        
    // }
    List<List<Integer>> res = new ArrayList<>();

    public void findcombo(int start, List<Integer> cur, int[] candidates, int target){
        // if(target==0 && !res.contains(cur)){
        if(target==0 ){
            res.add(new ArrayList<>(cur));
            return;
        }
        // if(start==candidates.length)
        //     return;
        
        // if(candidates[start]<=target){
        //     cur.add(candidates[start]);
        //     findcombo(start+1,cur,candidates,target-candidates[start]);
        //     cur.remove(cur.size()-1);
        // }
        // findcombo(start+1,cur,candidates,target);

        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i-1])
                continue;
            if(candidates[i]>target)
                break;
            cur.add(candidates[i]);
            findcombo(i+1,cur,candidates,target-candidates[i]);
            cur.remove(cur.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        findcombo(0,new ArrayList<Integer>(),candidates,target);
        return res;
    }
}