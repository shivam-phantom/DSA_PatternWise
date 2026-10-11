class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count=0;
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++){
            
            if(!visited[i]){
                count++;
                dfs(isConnected,i,visited);
            }
            
        }
        
        return count;
    }

    public void dfs(int[][] isConnected, int i, boolean[] visited){
        visited[i]=true;
        for(int nb =0;nb<isConnected.length;nb++){
            if(isConnected[i][nb]==1 && !visited[nb]){
                dfs(isConnected,nb,visited);
            }
        }
        // if(i>isConnected.length-1 || j>isConnected[0].length-1 || isConnected[i][j]==0)
        //     return;
        // if(isConnected[i][j]==1){
        //     isConnected[i][j]=0;
        //     dfs(isConnected,j,j+1);
        // }
        // dfs(isConnected,i,j+1);
    }
}