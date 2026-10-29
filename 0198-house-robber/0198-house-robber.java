class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n<2)
            return nums[n-1];
        int[] res = new int[nums.length];
        res[n-1] = nums[n-1];
        res[n-2] = Math.max(nums[n-2],res[n-1]);
        for(int i =n-3;i>=0;i--){
            res[i]=Math.max(nums[i]+res[i+2],res[i+1]);
        }
        return res[0];
        
    }
    public int doRob(int i, int[] nums){
        if(i>=nums.length)
            return 0;
        // int[] afterRob = doRob(i+2,nums);
        // int[] afterSkip = doRob(i+1,nums);

        int rob = nums[i] + doRob(i+2,nums);
        int skip =  doRob(i+1,nums);
        
        return Math.max(rob,skip);
    }
}