class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2*limit + 2];
        for(int i = 0; i < n/2; i++){
            int a = nums[i];
            int b = nums[n-1-i];
            int x = Math.min(a,b);
            int y = Math.max(a,b);
            diff[2] += 2;
            diff[x+1] -= 1;
            diff[x+y] -= 1;
            diff[x+y+1] += 1;
            diff[y+limit+1] += 1;
        }
        int ans = Integer.MAX_VALUE;
        int curr = 0;
        for(int i = 2 ; i <= 2 *limit; i++){
            curr += diff[i];
            ans = Math.min(ans,curr);
        }
        return ans;
    }
}