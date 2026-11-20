class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int curMax = nums[0];
        int curMin = nums[0];
        for(int i=1;i<nums.length;i++){
            
            int preMax = curMax;
            int preMin = curMin;
            
            curMax = Math.max(nums[i],Math.max(curMax*nums[i],curMin*nums[i]));
            curMin = Math.min(nums[i],Math.min(preMax*nums[i],curMin*nums[i]));

            max = Math.max(curMax,max);
        }
        return max;
    }
}