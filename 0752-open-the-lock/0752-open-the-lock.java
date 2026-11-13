class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>(Arrays.asList(deadends));
        if(visited.contains("0000"))
            return -1;
        if(target.equals("0000"))
            return 0;
        Queue<String> q = new LinkedList<>();
        q.offer("0000");
        visited.add("0000");
        int turn =0;
        
        while(!q.isEmpty()){
            int size = q.size();

            for(int i=0;i<size;i++){
                String lock = q.poll();
                if(lock.equals(target))
                    return turn;
                char[] arr = lock.toCharArray();
                for(int j=0;j<4;j++){
                    char ori = arr[j];
                    //step up
                    arr[j] = ori == '9'?'0':(char)(ori+1);
                    String newComb = new String(arr);
                    if(visited.add(newComb)){
                        q.offer(newComb);
                    }
                    //step down
                    arr[j] = ori == '0'?'9':(char)(ori-1);
                    String newCombD = new String(arr);
                    if(visited.add(newCombD)){
                        q.offer(newCombD);
                    }
                    arr[j]=ori;
                }
            }
            turn++;
        }
        return -1;
    }
}