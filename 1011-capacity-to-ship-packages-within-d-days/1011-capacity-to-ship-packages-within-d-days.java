class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int w:weights){
            max=Math.max(max,w);
            sum+=w;
        }
        int low=max;
        int high=sum;
        int res=sum;
        while(low<=high){
            int mid = low+(high-low)/2;
            int dCount = 0;
            int total =0;
            for(int w : weights){
                total+=w;
                if(total>=mid){
                    dCount++;
                    total = total==mid?0:w;
                }
            }
            if(total>0)
                dCount++;
            // System.out.println(mid+" "+dCount);
            if(dCount<=days){
                res=mid;
                high=mid-1;
            } else{
                low=mid+1;
            }
        }
        return res;
    }
}