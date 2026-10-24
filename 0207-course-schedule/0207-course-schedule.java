class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<numCourses;i++)
            adj.add(new ArrayList<>());
        for(int[] row: prerequisites){
            adj.get(row[1]).add(row[0]);
        }
        int[] color = new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(color[i]==0){
                if(dfs(i,adj,color))
                    return false;
            }
        }
        return true;
    }

    public boolean dfs(int node,List<List<Integer>> adj,int[] color){
        
        color[node] = 1;
        for(int nb : adj.get(node)){
            if(color[nb]==1)
                return true;
            else if(color[nb]==0){
                if(dfs(nb,adj,color))
                    return true;
            }
        }
        color[node]=2;
        return false;
    }
}