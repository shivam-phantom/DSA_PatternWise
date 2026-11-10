class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        // List of all src -> map time : list of nb at that instance
        // List<Map<Integer,List<Integer>>> adj = new ArrayList<>();
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] tm : times){
            int u = tm[0];
            int v = tm[1];
            int t = tm[2];
            adj.get(u).add(new int[]{v,t});
        }
        int time[] = new int[n+1];
        Arrays.fill(time,Integer.MAX_VALUE);
        int totalTime = 0;
        time[k] = 0;
        // pq will have v,t;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[] {k,time[k]});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int u = cur[0];
            int te = cur[1];
            for(int[] nb : adj.get(u)){
                int v = nb[0];
                int latency = nb[1];
                if(time[v]>te+latency){
                    time[v]=te+latency;
                    
                    pq.offer(new int[]{v,time[v]});
                }
            }
        }
        for(int i=1;i<=n;i++){
            int t=time[i];
            if(t == Integer.MAX_VALUE)
                return -1;
            totalTime = Math.max(totalTime,t);
        }
        return totalTime;
    }
}