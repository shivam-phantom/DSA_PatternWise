class Solution {
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows2 = grid2.length;
        int cols2 = grid2[0].length;
        int count =0;
        for(int i=0;i<rows2;i++){
            for(int j=0;j<cols2;j++){
                    if(grid2[i][j] == 1 ){
                        // count++;
                        if(dfs(grid1,grid2,i,j))
                            count++;
                    }
            }
        }
        return count;
    }

    public boolean dfs(int[][] grid1,int[][] grid2, int r, int c){
        if(r<0 || c<0 || r>grid2.length-1 || c>grid2[0].length-1 || grid2[r][c] != 1){
            return true;
        }
        // if(grid2[r][c] == 1 && grid1[r][c] != 1)
        //     return;
        // else if(grid2[r][c] == 1 && grid1[r][c] == 1)
            grid2[r][c] = -1;
        boolean flag = grid1[r][c] == 1;
        for(int[] d:dir){
            int row = r + d[0];
            int col = c + d[1];
            flag = dfs(grid1,grid2,row,col) && flag;
        }
        return flag;
    }
}