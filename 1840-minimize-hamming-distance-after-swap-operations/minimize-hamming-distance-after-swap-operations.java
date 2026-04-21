class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        int[] parent = new int[n];
        for(int i = 0; i < n ;i++){
            parent[i] = i;
        }
        for(int[] swap : allowedSwaps){
            union(swap[0],swap[1],parent);
        }
        Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
        for(int i = 0; i < n ;i++){
            int root = find(i,parent);
            map.putIfAbsent(root, new HashMap<>());
            Map<Integer,Integer> counts = map.get(root);
            counts.put(source[i], counts.getOrDefault(source[i],0) + 1);
        }
        int dist = 0;

        for(int i = 0; i < n ; i++){
            int root = find(i,parent);
            Map<Integer, Integer> counts = map.get(root);
            if(counts.getOrDefault(target[i],0) > 0){
                counts.put(target[i], counts.get(target[i]) - 1);
            }
            else{
                dist++;
            }
        }
        return dist;
    }

    private int find(int i, int[] parent){
        if(parent[i] == i){
            return i;
        }
        return parent[i] = find(parent[i],parent);
    }

    private void union(int i, int j, int[] parent){
        int root1 = find(i,parent);
        int root2 = find(j,parent);
        if(root1 != root2){
            parent[root1] = root2;
        }
    }
}