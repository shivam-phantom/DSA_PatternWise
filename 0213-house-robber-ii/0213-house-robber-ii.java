class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n<2)
            return nums[n-1];
        
        int case1 = robRange(nums,0,n-1);
        int case2 = robRange(nums,1,n);
        return Math.max(case1,case2);
    }

    public int robRange(int[] nums, int start,int n){
        if(n-start == 1)
            return nums[start];
        int[] res = new int[nums.length];
        res[n-1] = nums[n-1];
        res[n-2] = Math.max(nums[n-2],res[n-1]);
        for(int i =n-3;i>=start;i--){
            res[i]=Math.max(nums[i]+res[i+2],res[i+1]);
        }
        return res[start];
    }
}