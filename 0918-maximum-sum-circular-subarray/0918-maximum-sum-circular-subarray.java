class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSub = nums[0];
        int curmax = nums[0];
        int minSub = nums[0];
        int curmin = nums[0];
        int total = nums[0];
        for(int i=1;i<nums.length;i++){
            curmax = Math.max(curmax + nums[i],nums[i]);
            maxSub = Math.max(curmax,maxSub);

            curmin = Math.min(curmin + nums[i],nums[i]);
            minSub = Math.min(curmin,minSub);

            total += nums[i];
        }
        //all no. are negative 
        if(maxSub<0)
            return maxSub;
        return Math.max(maxSub,total-minSub);
        // int n = nums.length;
        // int[] cArr = new int[2*n];
        // for(int i=0;i<2*n;i++){
        //     cArr[i] = nums[i%n];
        // }
        // int cur = cArr[0];
        // int sum = cArr[0];
        // for(int i=1;i<cArr.length;i++){
        //     cur = Math.max(cur+cArr[i],cArr[i]);
        //     sum = Math.max(sum,cur);
        // }
        // return sum;
    }
}