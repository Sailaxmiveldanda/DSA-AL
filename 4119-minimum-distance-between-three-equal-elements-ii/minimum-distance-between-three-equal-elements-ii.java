class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int[] last1 = new int[n+1];
        int[] last2 = new int[n+1];
        Arrays.fill(last1,-1);
        Arrays.fill(last2,-1);
        int res =  Integer.MAX_VALUE;
        for(int i = 0; i < n ; i++){
            int val = nums[i];
            if(last1[val] != -1){
                if(last2[val] != -1){
                    int dist = 2 * (i - last2[val]);
                    res = Math.min(dist,res);
                }
                last2[val] = last1[val];
            }
            last1[val] = i;
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}