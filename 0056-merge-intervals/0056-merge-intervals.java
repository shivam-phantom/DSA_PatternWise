class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        int idx=-1;
        for(int[] interval : intervals){
            if(idx>=0 && res.get(idx)[1]>=interval[0]){
                int[] tmp = res.remove(idx);
                idx--;
                interval[0]=tmp[0];
                interval[1]=Math.max(interval[1],tmp[1]);
            }
            res.add(++idx,interval);
        }
        return res.toArray(new int[res.size()][2]);
    }
}