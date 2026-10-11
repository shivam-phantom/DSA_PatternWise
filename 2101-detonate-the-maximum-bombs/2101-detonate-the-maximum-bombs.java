class Solution {
    int maxBombs =0;
    
    List<List<Integer>> graph;
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        // visited = new boolean[n];
        graph = new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j)
                    continue;
                int x1 = bombs[i][0], y1 = bombs[i][1], r1 = bombs[i][2];
                int x2 = bombs[j][0], y2 = bombs[j][1];
                long dx = (long) x1 - x2;
                long dy = (long) y1 - y2;
                long distSq = dx * dx + dy * dy;
                long rSq = (long) r1 * r1;

                if(distSq<=rSq)
                    graph.get(i).add(j);
            }
        }
        for(int i=0;i<n;i++){
            maxBombs = Math.max(maxBombs, dfs(i,new boolean[n]));
        }
        return maxBombs;
    }
    public int dfs(int node,boolean[] visited){
        visited[node] = true;
        int count =1;
        for(int nb : graph.get(node)){
            if(!visited[nb]){
                count+=dfs(nb,visited);
            }
        }
        return count;
    }
}