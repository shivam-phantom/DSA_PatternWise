class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        // Arrays.fill(dp,amount+1);
        dp[0] = 1;
        for(int c : coins){
            for(int j=1;j<=amount;j++){
                if(j-c>=0)
                    dp[j] += dp[j-c];
            }
        }
        return dp[amount];
    }
}