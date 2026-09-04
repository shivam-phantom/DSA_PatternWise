class Solution {
    List<List<Integer>> output = new ArrayList<>();
    int n;
    public void backTrack(List<Integer> cur,boolean[] freq,int[] nums){
        if(cur.size() == n){
            output.add(new ArrayList<>(cur));
            return;
        }
        
        for(int i=0;i<n;i++){
            if(!freq[i]){
                freq[i]=true;
                cur.add(nums[i]);
                backTrack(cur,freq,nums);
                cur.remove(cur.size()-1);
                freq[i]=false;
            }
        }
        
    }
    public List<List<Integer>> permute(int[] nums) {
        n = nums.length;
        boolean[] freq = new boolean[n];
        backTrack(new ArrayList<Integer>(),freq,nums);
        return output;
    }
}