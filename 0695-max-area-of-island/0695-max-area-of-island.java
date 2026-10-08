class Solution {
    int dir[][] = {{-1,0},{0,-1},{1,0},{0,1}};
    int maxArea = 0;
    int[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        visited = new int[rows][cols];
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                if(grid[r][c]==1){
                    int area = dfs(grid,r,c);
                    maxArea = Math.max(maxArea,area);
                }
                
            }
        }
        return maxArea;
    }
    public int dfs(int[][] grid, int r, int c){
        if(r<0 || c <0 || r>=grid.length || c>=grid[0].length || grid[r][c]==0 )
            return 0;
        
        grid[r][c]=0;
        int area=1;
        for(int d[] : dir){
            int row = r + d[0];
            int col = c + d[1];
            area+=dfs(grid,row,col);
        }
        
        return area;
    }
}