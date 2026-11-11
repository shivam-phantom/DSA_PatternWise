class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        // int n = grid.get(0).length;
        int dist[][] = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        for(int r=0;r<n;r++){
            Arrays.fill(dist[r],-1);
            for(int c=0;c<n;c++){
                if(grid.get(r).get(c) == 1){
                    dist[r][c]=0;
                    queue.offer(new int[]{r,c});
                }
            }
        }
        int dir[][] = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            for(int[] d : dir){
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr>=0 && nr<n && nc>=0 && nc<n && dist[nr][nc]==-1){
                    dist[nr][nc] = dist[r][c] + 1;
                    queue.offer(new int[] {nr,nc});
                }
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        int best[][] =  new int[n][n];
        for(int[] row : best){
            Arrays.fill(row,-1);
        }
        best[0][0]=dist[0][0];
        pq.offer(new int[]{best[0][0],0,0});

        while(!pq.isEmpty()){
            int cur[] = pq.poll();

            int safeness = cur[0];
            int r = cur[1];
            int c = cur[2];

            if(r==n-1 && c==n-1)
                return safeness;
            if(safeness>dist[r][c])
                continue;
            for(int[] d:dir){
                int nr = r + d[0];
                int nc = c + d[1];
                if(nr<0 || nr>=n || nc<0 || nc>=n)
                    continue;
                int newSafeness = Math.min(safeness,dist[nr][nc]);
                if(newSafeness > best[nr][nc]){
                    best[nr][nc] = newSafeness;
                    pq.offer(new int[] {best[nr][nc],nr,nc});
                }
            }
        }
        return 0;
    }
}