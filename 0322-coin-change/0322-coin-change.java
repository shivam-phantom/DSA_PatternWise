class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        //updating the array with max value
        Arrays.fill(dp,amount+1);

        dp[0] = 0;
        for(int am = 1;am<=amount;am++){
            for(int c : coins){
                if(am-c>=0)
                    dp[am] = Math.min(dp[am],dp[am-c]+1);
            }
        }
        return dp[amount] > amount?-1:dp[amount];
    }
}