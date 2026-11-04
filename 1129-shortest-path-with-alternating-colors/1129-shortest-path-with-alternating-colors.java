class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        int dist[][] = new int[n][2];
        int INF = Integer.MAX_VALUE/2;
        for(int i=0;i<n;i++)
            Arrays.fill(dist[i],INF);
        dist[0][0]=0;
        dist[0][1]=0;

        for(int i=0;i<n;i++){
            boolean changed = false;
            //Red edges
            for(int[] red : redEdges){
                int u=red[0];
                int v=red[1];
                if(dist[u][1] != INF && dist[v][0] > dist[u][1]+1){
                    dist[v][0] = dist[u][1]+1;
                    changed = true;
                }   
            }

            //Blue edges
            for(int[] blue : blueEdges){
                int u=blue[0];
                int v=blue[1];
                if(dist[u][0] != INF && dist[v][1] > dist[u][0]+1){
                    dist[v][1] = dist[u][0]+1;
                    changed = true;
                }   
            }

            if(!changed)
                break;

        }

        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            int minDis = Math.min(dist[i][0],dist[i][1]);
            ans[i] = minDis == INF?-1:minDis;
        }
        return ans;
    }
}