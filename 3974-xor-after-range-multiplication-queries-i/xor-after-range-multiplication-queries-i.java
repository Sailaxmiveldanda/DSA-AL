class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        long mod = 1_000_000_007L;
        int n = nums.length;
        for(int[] query : queries){
            int l = query[0];
            int r = query[1];
            int k = query[2];
            long v = (long) query[3];
            if(v == 1) continue;
            for(int i = l; i <= r ; i += k){
                nums[i] = (int) (((long)nums[i] * v ) % mod);
            }
        }
        int sum = 0;
        for(int num : nums){
            sum ^= num;
        }
        return sum;
    }
}