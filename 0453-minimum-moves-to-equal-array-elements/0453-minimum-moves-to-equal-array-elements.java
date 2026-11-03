class Solution {
    public int minMoves(int[] nums) {

        // incr (n-1) element is equivalent to decrement 1 element in each iteration.
        //Therefore we can calculate the min element 1st
        //Then for each element we will add the difference with min
        //return the sum 
        int min = Integer.MAX_VALUE;
        for(int n : nums)
            min = Math.min(n,min);
        int total =0;
        for(int n : nums)
            total += n-min;
        
        return total;
    }
}