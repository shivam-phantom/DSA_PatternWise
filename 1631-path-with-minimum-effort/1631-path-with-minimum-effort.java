class Solution {
    public int minimumEffortPath(int[][] heights) {
        // List<List<Integer>> adj = new ArrayList<>();
        // int n = heights.length * heights[0].length;
        // for(int i=0;i<n;i++)
        //     adj.add(new ArrayList<>());
        // for(int[] row : heights)
        //each cell is a node in graph
        //it can move in the dir hence 4 edges
        //weight of each edge is the |height(u)-height(v)|
        //relaxation : newEffort = Math.max(currentEffort,edgeWeight);
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        int m = heights.length;
        int n = heights[0].length;
        int dist[][] = new int[m][n];
        //pq contains {effort,row,col}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);

        for(int[] row:dist)
            Arrays.fill(row,Integer.MAX_VALUE);
        dist[0][0]=0;
        pq.offer(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int r = cur[1];
            int c = cur[2];
            int effort = cur[0];
            if(effort>dist[r][c])
                continue;
            if(r == m-1 && c == n-1)
                return effort;
            for(int[] row : dir){
                int nr = r + row[0];
                int nc = c + row[1];
                if(nr<0 || nc <0 || nr>=m ||nc>=n)
                    continue;
                int newEff = Math.max(effort,Math.abs(heights[r][c] - heights[nr][nc]));
                if(newEff <dist[nr][nc]){
                    dist[nr][nc]=newEff;
                    pq.offer(new int[]{newEff,nr,nc});
                }
                    
            }
        }
        return 0;
    }
}