class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(dfs(i,color,graph))
                res.add(i);
        }
        return res;
    }

    public boolean dfs(int node, int[] color,int[][] graph){
        if(color[node] != 0)
            return color[node] == 2;
        color[node] = 1;

        for(int nb : graph[node]){
            if(color[nb] == 2)
                continue;
            if(color[nb] == 1 || !dfs(nb,color,graph))
                return false;
        }
        color[node] = 2;
        return true;
    }
}