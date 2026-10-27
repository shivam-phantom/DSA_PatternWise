class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        if(n==1)
            return time[n-1];
        
        List<List<Integer>> adj = new ArrayList<>();
        int[] degree = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] ed : relations){
            int u = ed[0];
            int v = ed[1];
            adj.get(u).add(v);
            degree[v]++;
        }

        int[] finishTime =  new int[n+1];

        for(int i=1;i<=n;i++){
            if(degree[i] == 0){
                q.offer(i);
                finishTime[i] = time[i-1];
            }
        }

        int ans = 0;
        // int rem=n;
        while(!q.isEmpty()){
            
            int node = q.poll();
            
            ans = Math.max(ans, finishTime[node]);
            for(int nb : adj.get(node)){
                finishTime[nb] = Math.max(finishTime[node] + time[nb-1],finishTime[nb]);
                degree[nb]--;
                if(degree[nb]==0){
                    q.offer(nb);
                }
            }
        }
        
        return ans;
    }
}