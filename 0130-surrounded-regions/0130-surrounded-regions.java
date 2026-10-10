class Solution {
    int[][] dir = {{-1,0},{0,-1},{1,0},{0,1}};
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for(int i=0;i<rows;i++){
            dfs(board,i,0);
            dfs(board,i,cols-1);
        }

        for(int i=0;i<cols;i++){
            dfs(board,0,i);
            dfs(board,rows-1,i);
        }

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    public void dfs(char[][] board, int r,int c){
        if(r<0 || c<0 || r>=board.length || c>=board[0].length|| board[r][c] != 'O')
            return;
        board[r][c] = '#';
        for(int[] d : dir){
            int row = r + d[0];
            int col = c + d[1];
            dfs(board,row,col);
        }
    }
}