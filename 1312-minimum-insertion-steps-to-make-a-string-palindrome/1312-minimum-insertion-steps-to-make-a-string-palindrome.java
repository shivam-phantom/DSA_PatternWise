class Solution {
    public int minInsertions(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int m = s.length();
        int[][] dp = new int[m+1][m+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) == rev.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else{
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        int n = dp[m][m];
        return m-n;
    }
}