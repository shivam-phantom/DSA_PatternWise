class Solution {
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] res = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] == 0){
                    res[i][j]=0;
                    q.offer(new int[]{i,j});
                } else {
                    res[i][j]=-1;
                }
                
            }
        }
        while(!q.isEmpty()){
            int[] ind = q.poll();
            int row = ind[0];
            int col = ind[1];
            for(int[] d:dir){
                int r= row + d[0];
                int c=col + d[1];
                if(r>=0 && c>=0 && r<mat.length && c<mat[0].length && res[r][c]==-1){
                    res[r][c]=res[row][col]+1;
                    q.offer(new int[]{r,c});
                }
            }
            
        }
        return res;
    }

    
}