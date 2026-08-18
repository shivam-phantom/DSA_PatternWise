class Solution {
    public int candy(int[] ratings) {

        int n = ratings.length;
        int total = 0;
        int[] candies = new int[n];
        Arrays.fill(candies,1);

        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1])
                candies[i]=candies[i-1]+1;
        }

        for(int i=n-2;i>=0;i--){
            if(ratings[i]>ratings[i+1])
                candies[i]=Math.max(candies[i],candies[i+1]+1);
        }

        // PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        // for(int i=0;i<n;i++){
        //     pq.add(new int[]{i,ratings[i]});
        // }
        // while(!pq.isEmpty()){
        //     int[] child = pq.poll();
        //     int id = child[0];
        //     if(id>0 && rate>ratings[id-1])
        //         candies[id]=Math.max(candies[id],candies[id-1]+1);

        //     if(id<n-1 && rate>ratings[id+1])
        //             candies[id]=Math.max(candies[id],candies[id+1]+1);

        // }
        for(int i : candies){
            total+=i;
        }
        return total;
    }
}