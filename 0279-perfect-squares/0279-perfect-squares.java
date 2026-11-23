class Solution {
    public int numSquares(int n) {
        if(n==1)
            return n;
        List<Integer> sqList = new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(i*i<=n)
                sqList.add(i*i);
            else
                break;
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp,n+1);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            for(int j:sqList){
                if(i-j>=0)
                    dp[i]=Math.min(dp[i],dp[i-j]+1);
            }
        }
        return dp[n];
    }
}