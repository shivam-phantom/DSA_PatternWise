class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        

        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for(int[] ed : edges){
            adj.get(ed[0]).add(new int[]{ed[1],ed[2]});
            adj.get(ed[1]).add(new int[]{ed[0],ed[2]});
        }
        int minReach = n;
        int res = -1;
        for(int i =0;i<n;i++){
            int countReach = dj(n,adj,i,distanceThreshold);

            if(countReach<=minReach){
                minReach=countReach;
                res=i;
            }
        }
        return res;
    }
    public int dj(int n,List<List<int[]>> adj,int src, int distanceThreshold){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        pq.offer(new int[]{0,src});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int d = cur[0];
            int u = cur[1];
            for(int[] nb : adj.get(u)){
                int v = nb[0];
                int wt = nb[1];
                if(dist[u]+wt < dist[v]){
                    dist[v]=dist[u]+wt;
                    pq.offer(new int[]{dist[v],v});
                }
            }
        }
        int count = 0;
        for(int i=0;i<n;i++){
            if(src != i && dist[i]<=distanceThreshold)
                count++;
        }
        return count;
    }
}