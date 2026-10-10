class Solution {
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i=0;i<rows;i++){
            dfs(grid,i,0);
            dfs(grid,i,cols-1);
        }
        for(int i=0;i<cols;i++){
            dfs(grid,0,i);
            dfs(grid,rows-1,i);
        }
        int count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1)
                    count++;
            }
        }
        return count;
    }

    public void dfs(int[][] grid , int r , int c){
        if(r<0 || c<0 || r>grid.length-1 || c>grid[0].length-1 || grid[r][c] != 1)
            return;
        grid[r][c]=-1;
        for(int[] d:dir){
            int row = r + d[0];
            int col = c + d[1];
            dfs(grid,row,col);
        }
    }
}