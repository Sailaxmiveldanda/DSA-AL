class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n ; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        List<Integer> res = new ArrayList<>();
        for(int query : queries){
            int val = nums[query];
            List<Integer> list = map.get(val);
            if(list.size() == 1){
                res.add(-1);
                continue;
            }
            int pos = Collections.binarySearch(list,query);
            int size = list.size();
            int left = list.get((pos - 1 + size) % size);
            int right = list.get((pos + 1) % size);
            int d1 = Math.abs(left - query);
            int d2 = Math.abs(right - query);
            d1 = Math.min(d1, n - d1);
            d2 = Math.min(d2, n - d2);
            int g = Math.min(d1,d2);
            res.add(g); 
        }
        return res;
    }
}