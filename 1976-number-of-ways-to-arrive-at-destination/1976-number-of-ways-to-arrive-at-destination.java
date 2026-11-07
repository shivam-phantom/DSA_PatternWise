class Solution {
    static final int MOD = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        
        //for list u : 0-v(neighbour) 1-edget uv weight
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] road : roads){
            adj.get(road[0]).add(new int[] {road[1],road[2]});
            adj.get(road[1]).add(new int[] {road[0],road[2]});
        }
        //min heap for shortest path
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        // long minDist = Integer.MAX_VALUE;
        long[] dist = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        dist[0]=0;
        pq.offer(new long[] {0,0});
        while(!pq.isEmpty()){
            long[] cur = pq.poll();
            int u = (int)cur[0];
            long curDist = cur[1];
            // if(u==n-1){
            //     minDist = curDist;
            //     break;
            // }
            if(curDist>dist[u])
                continue;
            for(int[] nb : adj.get(u)){
                int v = nb[0];
                int wt = nb[1];
                if(dist[v]>dist[u]+wt){
                    dist[v]=dist[u]+wt;
                    pq.offer(new long[]{v,dist[v]});
                }
            }
        }
        
        List<List<Integer>> dag = new ArrayList<>();
        for(int i=0;i<n;i++)
            dag.add(new ArrayList<>());
        for(int u=0;u<n;u++){
            for(int[] nb : adj.get(u)){
                int v = nb[0];
                int wt = nb[1];
                if(dist[u]+wt==dist[v])
                    dag.get(u).add(v);
            }
        }
        long[] memo = new long[n];
        Arrays.fill(memo,-1);
        return (int) dfs(0,n-1,dag,memo);
    }

    private long dfs(int u,int dest,List<List<Integer>> dag,long[] memo){
        if(u==dest)
            return 1;
        if(memo[u] != -1)
            return memo[u];
        long ways =0;
        for(int v : dag.get(u)){
            ways = (ways + dfs(v,dest,dag,memo))%MOD;
        }
        return memo[u]=ways;
    }
}