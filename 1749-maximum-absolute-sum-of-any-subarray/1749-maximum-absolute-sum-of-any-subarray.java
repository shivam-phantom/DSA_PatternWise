class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = nums[0];
        int cur =nums[0];
        int minSum = nums[0];
        int curMin =nums[0];
        for(int i=1;i<nums.length;i++){
            cur =Math.max(cur+nums[i],nums[i]);
            maxSum = Math.max(cur,maxSum);

            curMin =Math.min(curMin+nums[i],nums[i]);
            minSum = Math.min(curMin,minSum);
        }
        return Math.max(maxSum,Math.abs(minSum));
    }
}