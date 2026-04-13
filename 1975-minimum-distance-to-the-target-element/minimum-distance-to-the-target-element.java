class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < n ; i++){
            if(nums[i] == target){
                int dist = Math.abs(i-start);
                res = Math.min(res,dist);
            }
        }
        return res;
    }
}