class Solution {
    List<List<Integer>> output = new ArrayList<>();
    int n;

    public void backTrack(int start,List<Integer> cur ,int[] nums){

        if(output.isEmpty() || !output.contains(cur))
            output.add(new ArrayList<>(cur));
        for(int i=start;i<n;i++){
            cur.add(nums[i]);
            backTrack(i+1,cur,nums);
            cur.remove(cur.size()-1);
        }

    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        n = nums.length;
        backTrack(0,new ArrayList<Integer>(),nums);
        return output;
    }
}