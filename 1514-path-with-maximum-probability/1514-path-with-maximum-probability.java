class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for(int i=0;i<edges.length;i++){
            int[] ed = edges[i];
            adj.get(ed[0]).add(new double[]{ed[1],succProb[i]});
            adj.get(ed[1]).add(new double[]{ed[0],succProb[i]});
        }
        
        double[] prob = new double[n];
        // Arrays.fill(prob,Double.MAX_VALUE);
        prob[start_node]=1.0;
        // PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b)->Double.compare(b[1],a[1]));
        pq.offer(new double[] {start_node,prob[start_node]});
        while(!pq.isEmpty()){
            double[] cur = pq.poll();
            double currProb = cur[1];
            int u = (int)cur[0];
            if (u == end_node)
                return currProb;
            if (currProb < prob[u])
                continue;
            // int v = (int)cur[2];
            // if(v == end_node)
            //     return pb;
            
            for(double[] ele : adj.get(u)){
                int v = (int)ele[0];
                double pb = ele[1];
                if( prob[v] < prob[u] * pb ){

                    prob[v]=currProb * pb;
                    pq.offer(new double[]{v,prob[v]});
                }
            }

        }

        return prob[end_node];
    }
}