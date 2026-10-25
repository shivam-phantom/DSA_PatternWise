class Solution {
    List<Integer> resList;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        resList = new ArrayList<>();
        int[] res = new int[numCourses];
        int color[] = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());
        for(int[] edge : prerequisites){
            adj.get(edge[1]).add(edge[0]);
        }
        // int idx=0;
        for(int i=0;i<numCourses;i++){
            if(color[i]==0)
                if(dfs(i,color,adj))
                    return new int[0];
        }
        for(int i=numCourses-1;i>=0;i--)
            res[numCourses-i-1]=resList.get(i);
        return res;
    }
    //return true if there is cycle
    public boolean dfs(int node,int[] color,List<List<Integer>> adj){
        color[node]=1;

        for(int nb:adj.get(node)){
            if(color[nb]==1)
                return true;
            if(color[nb]==0)
                if(dfs(nb,color,adj))
                    return true;
        }
        color[node]=2;
        resList.add(node);
        return false;
    }
}