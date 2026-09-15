class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        // int dp[] = new int[n+1];
        // dp[n]=0;
        // dp[n-1]=cost[n-1];
        int last1=0;
        int last2=cost[n-1];
        for(int i = n-2;i>=0;i--){
            // dp[i]=cost[i]+Math.min(dp[i+1],dp[i+2]);
           int cur=cost[i]+Math.min(last1,last2);
           last1=last2;
           last2=cur;
        }

        return Math.min(last2,last1);
    }
}