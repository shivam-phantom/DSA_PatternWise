class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean visited[] = new boolean[n];
        dfs(rooms,0,visited);
        for(int i=0;i<n;i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }

    public void dfs(List<List<Integer>> rooms, int i,boolean[] visited){
        if(visited[i])
            return;
        visited[i]=true;
        for(int key : rooms.get(i)){
            if(!visited[key])
                dfs(rooms,key,visited);
        }
    }

}