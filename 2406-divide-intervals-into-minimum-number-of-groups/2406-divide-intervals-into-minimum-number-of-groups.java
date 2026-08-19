class Solution {
    public int minGroups(int[][] intervals) {
        //sort based on start time.
        //add end time in PQ based the sorted array.
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);

        PriorityQueue<Integer> group = new PriorityQueue<>();
        for(int[] interval : intervals){
            if(!group.isEmpty() && group.peek()<interval[0])
                group.poll();
            
            group.offer(interval[1]);
        }

        return group.size();
    }
}