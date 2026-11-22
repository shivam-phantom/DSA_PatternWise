class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int num : nums)
            total+=num;
        // if total is odd then it
        if (total % 2 != 0)
            return false;
        int target = total/2;
        Boolean dp[][] = new Boolean[nums.length][target+1];
        return solve(0,0,target,nums,dp);
    }
    public boolean solve(int i,int curSum, int target,int[] nums,Boolean[][] dp){
        if(i==nums.length || curSum > target)
            return false;
        if(curSum == target)
            return true;
        if(dp[i][curSum] != null)
            return dp[i][curSum];

        boolean noPick = solve(i + 1, curSum, target, nums, dp);
        boolean pick = solve(i+1,curSum+nums[i],target,nums,dp);
        
        return dp[i][curSum] = pick || noPick;
    }
}                                               