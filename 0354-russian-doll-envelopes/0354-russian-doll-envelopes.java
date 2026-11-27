class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a,b)->{
            if(a[0] == b[0]){
                return b[1] - a[1];
            } 
            return a[0]-b[0];
        });
        List<Integer> tails = new ArrayList<>();
        for(int[] row : envelopes){
            int low=0;
            int high = tails.size();
            while(low<high){
                int mid = low + (high-low)/2;
                if(tails.get(mid) < row[1])
                    low = mid+1;
                else
                    high=mid;
            }
            if(low == tails.size())
                tails.add(row[1]);
            else
                tails.set(low,row[1]);
        }
        return tails.size();
    }
}