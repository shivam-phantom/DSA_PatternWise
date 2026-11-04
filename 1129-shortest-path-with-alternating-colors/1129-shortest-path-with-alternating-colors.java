class Solution {
    public int[] shortestAlternatingPaths1(int n, int[][] redEdges, int[][] blueEdges) {
        //Bellman Ford Algo
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
                //Relaxation logic
                if(dist[u][1] != INF && dist[v][0] > dist[u][1]+1){
                    dist[v][0] = dist[u][1]+1;
                    changed = true;
                }   
            }

            //Blue edges
            for(int[] blue : blueEdges){
                int u=blue[0];
                int v=blue[1];
                //Relaxation logic
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
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {

        List<List<Integer>> redAdj = new ArrayList<>();
        List<List<Integer>> blueAdj = new ArrayList<>();
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][2];
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for(int i=0;i<n;i++){
            redAdj.add(new ArrayList<>());
            blueAdj.add(new ArrayList<>());
        }
        for(int[] red : redEdges){
            redAdj.get(red[0]).add(red[1]);
        }
        for(int[] blue : blueEdges){
            blueAdj.get(blue[0]).add(blue[1]);
        }
        //0 = RED
        //1 = BLUE
        q.offer(new int[]{0,0});
        q.offer(new int[]{0,1});
        visited[0][0] = true;
        visited[0][1] = true;

        int distance =0;
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                int[] cur = q.poll();
                
                if(ans[cur[0]] == -1)
                    ans[cur[0]] = distance;
                //Red 
                if(cur[1]==1){
                    for(int nb : redAdj.get(cur[0])){
                        if(!visited[nb][0]){
                            q.offer(new int[] {nb,0});
                            visited[nb][0]=true;
                        }
                    }
                } else {
                    for(int nb : blueAdj.get(cur[0])){
                        if(!visited[nb][1]){
                            q.offer(new int[] {nb,1});
                            visited[nb][1]=true;
                        }
                        
                    }
                }
            }
            distance++;
        }

        return ans;

    }
}