class Solution {
    int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                    // break;
                }    
            }
        }

        int time=-1;
        while(!q.isEmpty()){
            // time++;
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] idx = q.poll();
                int row = idx[0];
                int col = idx[1];
                for(int[] d: dir){
                    int r = row+d[0];
                    int c =col+d[1];
                    if(r>=0 && c>=0 && r<m && c<n && grid[r][c]==1){
                        grid[r][c]=2;
                        q.offer(new int[]{r,c});
                    }
                }
            }
            time++;
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return time==-1?0:time;
    }
}