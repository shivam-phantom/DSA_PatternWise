class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total =0;

        for(int num : nums)
            total+=num;
        
        if(Math.abs(target)>total)
            return 0;
        
        if((target + total)%2 != 0)
            return 0;
        int req  = (target+total)/2;
        int n = nums.length;
        int dp[][] = new int[n+1][req+1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            int num = nums[i-1];
            for(int sum =0;sum<=req;sum++){
                dp[i][sum] = dp[i-1][sum];

                if(num<=sum){
                    dp[i][sum] += dp[i-1][sum-num];
                }
            }
        }
        return dp[n][req];
    }
}