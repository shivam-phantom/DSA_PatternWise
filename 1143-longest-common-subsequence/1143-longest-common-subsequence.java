class Solution {
    int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        dp = new int[m+1][n+1];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        
        int val = lcs(text1,text2,m,n);
        return val;
    }
    int lcs(String text1, String text2, int m, int n){
        if(m==0 || n==0){
            dp[m][n] = 0;
            return dp[m][n];
        }
        if(dp[m][n]!=-1)
            return dp[m][n];
        
        if(text1.charAt(m-1) == text2.charAt(n-1)){
            dp[m][n] = 1+lcs(text1,text2,m-1,n-1);
        } else{
            dp[m][n] = Math.max(lcs(text1,text2,m-1,n),lcs(text1,text2,m,n-1));
        }
        return dp[m][n];
    }
}