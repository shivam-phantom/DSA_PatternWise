class Solution {
    
    List<List<Integer>> output = new ArrayList<>();
    // int n ;
    public List<List<Integer>> combine(int n, int k) {
        // n = nums.length;
        List<Integer> curr = new ArrayList<>();
        // output.add(curr);
        backTrack(1,curr,n,k);
        return output;
    }

    public void backTrack(int start,List<Integer> currSet,int n,int k){
        if(currSet.size()==k)
            output.add(new ArrayList<>(currSet));
        for (int i = start; i <= n; ++i) {
            currSet.add(i);
            backTrack(i+1,currSet,n,k);
            currSet.remove(currSet.size()-1);
        }
    }
}