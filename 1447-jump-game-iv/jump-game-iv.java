class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n==1){
            return 0;
        }
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n ; i++){
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        boolean[] visit = new boolean[n];
        visit[0] = true;
        int steps = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int s = 0 ; s < size ; s++){
                int curr = queue.poll();
                if(curr == n-1){
                    return steps;
                }
                List<Integer> neighbor = map.get(arr[curr]);
                if(neighbor != null){
                    for(int next : neighbor){
                        if(!visit[next]){
                            visit[next] = true;
                            queue.offer(next);
                        }
                    }
                    neighbor.clear();
                }
                if (curr + 1 < n && !visit[curr + 1]) {
                    visit[curr + 1] = true;
                    queue.offer(curr + 1);
                }
                if (curr - 1 >= 0 && !visit[curr - 1]) {
                    visit[curr - 1] = true;
                    queue.offer(curr - 1);
                }
            }
            steps++;
        }
        return -1;
    }
}