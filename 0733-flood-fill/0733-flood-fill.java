class Solution {
    int dir[][] = {{-1,0},{0,-1},{1,0},{0,1}};
    int ori ;
    // Set<int[]> set = new HashSet<>();
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        ori = image[sr][sc];
        fill(image,sr,sc,color);
        return image;
    }
    public void fill(int[][] image, int sr, int sc, int color){
        // if(set.contains(new int[]{sr,sc}))
        //     return;
        image[sr][sc] = image[sr][sc]==ori?color:image[sr][sc];
        // set.add(new int[]{sr,sc});
        for(int[] d : dir){
            int row = sr+d[0];
            int col = sc+d[1];
            if(row>=0 && row<image.length && col>=0 && col<image[0].length && image[row][col] == ori && image[row][col] != color){
                fill(image,row,col,color);
            }
        }
        return;
    }
}