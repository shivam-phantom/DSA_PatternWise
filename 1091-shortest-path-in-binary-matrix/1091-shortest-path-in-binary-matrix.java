class Solution {
    int[][] dir = {{1,0},{0,1},{-1,0},{0,-1},{-1,-1},{1,1},{-1,1},{1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(grid[0][0]==1 || grid[m-1][n-1]==1)
            return -1;
        Queue<int[]> q = new LinkedList<>();
        
        int[][] res = new int[m][n];
        q.offer(new int[]{0,0});
        grid[0][0]=1;
        res[0][0]=1;
        while(!q.isEmpty()) {
            int[] idx = q.poll();
            int row = idx[0];
            int col = idx[1];
            for(int[] d:dir){
                int r = row + d[0];
                int c = col +d[1];
                if(r>=0 && c>=0 && r<m && c <n && grid[r][c]==0){
                    res[r][c] = res[row][col]+1;
                    grid[r][c]=1;
                    q.offer(new int[] {r,c});
                }
            } 
        }
        return res[m-1][n-1] == 0?-1:res[m-1][n-1];
    }
}