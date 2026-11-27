class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        List<String>[] dp = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            dp[i] = new ArrayList<>();
        }
        Set<String> dict = new HashSet<>(wordDict);
        dp[0].add("");
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                String word = s.substring(j,i);
                if(dict.contains(word)){
                    for(String pre : dp[j]){
                        if(pre.isEmpty())
                            dp[i].add(word);
                        else
                            dp[i].add(pre+" "+word);
                    }
                }
            }
        }
        return dp[n];
    }
}