class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int curSum = nums[0];
        for(int j=1;j<nums.length;j++){
            int i = nums[j];
            curSum = Math.max(curSum+i,i);
            sum  = Math.max(curSum,sum);
        }
        return sum;
    }
}