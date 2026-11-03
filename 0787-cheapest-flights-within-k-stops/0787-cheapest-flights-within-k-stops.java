class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
       
        int[] dis = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src]=0;
        //K stops between src and dst means we can go till k+1 edges in the shortest path at most
        for(int i=0;i<=k;i++){
            int[] tmp = dis.clone();
            for(int[] fli : flights){
                int u = fli[0];
                int v = fli[1];
                int price = fli[2];
                if(dis[u]!=Integer.MAX_VALUE && dis[u] + price < tmp[v])
                    tmp[v]=dis[u] + price;
            }
            dis=tmp;
        }
        return dis[dst] == Integer.MAX_VALUE?-1:dis[dst];
    }
}