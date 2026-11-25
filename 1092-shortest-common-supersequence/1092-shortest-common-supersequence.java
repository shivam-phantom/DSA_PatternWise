class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[m+1][n+1];
        // for(int[] row : dp)
        //     Arrays.fill(row,-1);
        // lcs(str1,str2,dp,m,n);
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];

                }else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        int i = m;
        int j = n;
        StringBuffer sb = new StringBuffer();
        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }else{
                if(dp[i-1][j]>dp[i][j-1]){
                    sb.append(str1.charAt(i-1));
                    i--;
                }else{
                    sb.append(str2.charAt(j-1));
                    j--;
                }
            }
        }
        while(i>0){
            sb.append(str1.charAt(i-1));
            i--;
        }
        while(j>0){
            sb.append(str2.charAt(j-1));
            j--;
        }
        return sb.reverse().toString();
    }
    public int lcs(String str1, String str2, int[][] dp, int m, int n){
        if(m == 0 || n == 0){
            dp[m][n]=0;
            return dp[m][n];
        }
        if(dp[m][n] != -1)
            return dp[m][n];
        if(str1.charAt(m-1) == str2.charAt(n-1))
            dp[m][n] = 1 + lcs(str1,str2,dp,m-1,n-1);
        else
            dp[m][n] = Math.max(lcs(str1,str2,dp,m-1,n),lcs(str1,str2,dp,m,n-1));
        return dp[m][n];
    }
}