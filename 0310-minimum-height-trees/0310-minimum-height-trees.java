class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1)
            return List.of(0);
        int[] degree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());

        for(int[] edg : edges){
            int u = edg[0];
            int v = edg[1];
            adj.get(u).add(v);
            adj.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }
        for(int i=0;i<n;i++){
            if(degree[i]==1)
                q.offer(i);
        }
        int rem = n;
        while(rem>2){
            int size = q.size();
            rem -= size;
            for(int i=0;i<size;i++){
                int node = q.poll();
                for(int nb : adj.get(node)){
                    degree[nb]--;
                    if(degree[nb] == 1)
                        q.offer(nb);
                }
                    
            }
        }
        return new ArrayList<>(q);    
    }
}