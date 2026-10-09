class Solution {
    int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            dfs(heights,i,0,pacific);
            dfs(heights,i,cols-1,atlantic);
        }
        for(int j=0;j<cols;j++){
            dfs(heights,0,j,pacific);
            dfs(heights,rows-1,j,atlantic);
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(pacific[i][j] && atlantic[i][j])
                    res.add(List.of(i,j));
            }
        }
        return res;
    }

    public void dfs(int[][] heights,int r, int c,boolean[][] ocean){
        ocean[r][c] = true;

        for(int[] d:dir){
            int row = r+d[0];
            int col = c+d[1];
            if(row<0 || col<0 || row>heights.length-1 || col>heights[0].length-1)
                continue;
            if(ocean[row][col])
                continue;
            int nextH = heights[row][col];
            if(nextH>=heights[r][c])
                dfs(heights,row,col,ocean);
            
        }

    }
}