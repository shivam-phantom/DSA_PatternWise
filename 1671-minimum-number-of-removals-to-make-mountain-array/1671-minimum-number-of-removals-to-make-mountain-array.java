class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n= nums.length;
        List<Integer> tails = new ArrayList<>();
        // List<Integer> lds = new ArrayList<>();
        int lis[] = new int[n];
        int lds[] = new int[n];

        //left to right LIS
        for(int i=0;i<n;i++){
            int pos = lowerBound(tails,nums[i]);
            lis[i] = pos+1;
            if(pos==tails.size())
                tails.add(nums[i]);
            else
                tails.set(pos,nums[i]);
        }
        tails.clear();
        for(int i=n-1;i>=0;i--){
            int pos = lowerBound(tails,nums[i]);
            lds[i] = pos+1;
            if(pos==tails.size())
                tails.add(nums[i]);
            else
                tails.set(pos,nums[i]);
        }
        int maxMount = 0;
        for(int i =0;i<n;i++){
            if (lis[i] > 1 && lds[i] > 1) {
                int mountain = lis[i]+lds[i]-1;
                maxMount = Math.max(maxMount,mountain);
            }
        }
        return n-maxMount;
    }
    public int lowerBound(List<Integer> tails,int num){
        int low = 0;
        int high = tails.size();
        while(low<high){
            int mid = low + (high-low)/2;
            if(tails.get(mid) < num)
                low = mid+1;
            else
                high = mid;
        }
        return low;
    }
}