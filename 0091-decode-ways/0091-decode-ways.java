class Solution {
    public int numDecodings(String s) {
        Integer[] dp = new Integer[s.length()];
        return solve(s,dp,0);
    }
    public int solve(String s, Integer[] dp, int i){
        if(i==s.length())
            return 1;
        if(s.charAt(i)=='0')
            return 0;
        if(dp[i] != null)
            return dp[i];
        int ways = solve(s,dp,i+1);
        if((i+1)<s.length()){
            int num = (s.charAt(i)-'0')*10 + (s.charAt(i+1)-'0');
            if(num>=10 && num<=26)
                ways += solve(s,dp,i+2);
        }
        return dp[i]=ways;
    }
}