class Solution {
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count=0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid,int i,int j){
        if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1 || grid[i][j] == '0'){
            return;
        }
        grid[i][j] = '0';
        for(int[] d:dir){
            int row = i +d[0];
            int col = j +d[1];
            dfs(grid,row,col);
        }
    }
}