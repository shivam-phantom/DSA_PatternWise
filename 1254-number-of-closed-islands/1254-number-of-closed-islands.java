class Solution {
    int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==0)
                    if(dfs(grid,i,j))
                        count++;
            }
        }
        return count;
    }

    public boolean dfs(int[][] grid, int r, int c){
        if(r<0 || c<0 || r>grid.length-1 || c> grid[0].length-1)
            return false;
        if( grid[r][c]==-1 || grid[r][c]== 1)
            return true;
        grid[r][c] = -1;
        boolean flag = true;
        for(int d[]:dir){
            int row = r + d[0];
            int col = c + d[1];
            flag = dfs(grid,row,col) && flag ;
        }
        return flag;
    }
}