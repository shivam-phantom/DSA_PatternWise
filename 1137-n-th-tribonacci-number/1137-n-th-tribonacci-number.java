class Solution {
    public int tribonacci(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return n;
        int[] dp =  new int[n+1];
        // Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        if(n<3)
            return dp[n];
        return rec(dp,n);
    }
    public int rec(int[] dp, int n){
        if(n<3)
            return dp[n];
        // if(dp[n]!=-1)
        //     return dp[n];
        rec(dp,n-1);
        dp[n]=dp[n-3]+dp[n-2]+dp[n-1];
        return dp[n];
    }
}