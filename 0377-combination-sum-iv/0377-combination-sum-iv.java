class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0]=1;
        for(int t=1;t<=target;t++){
            for(int i:nums){
                if(t-i>=0)
                    dp[t] +=dp[t-i];
            }
        }
        return dp[target];
    }
}