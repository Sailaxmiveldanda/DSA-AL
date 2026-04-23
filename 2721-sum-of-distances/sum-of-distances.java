class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] res = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i= 0; i < n ; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for(List<Integer> list : map.values()){
            long rightSum = 0;
            for(int idx : list){
                rightSum += idx;
            }
            long leftSum = 0;
            int lc = 0;
            int rc = list.size();

            for(int idx : list){
                rightSum -= idx;
                rc--;
                long ld = (long) idx * lc - leftSum;
                long rd = rightSum - (long) idx * rc;
                res[idx] = ld + rd;
                lc++;
                leftSum += idx;
            }
        }
        return res;
    }
}