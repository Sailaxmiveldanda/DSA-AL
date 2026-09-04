class Solution {
    public int firstStableIndex(int[] nums, int k) {
        for(int i= 0; i < nums.length; i++){
            int mini = nums[i];
            int maxi = nums[i];
            for(int j = 0; j < i; j++){
                maxi =Math.max(maxi,nums[j]);
            }
            for(int p = i ; p < nums.length ; p++){
                mini = Math.min(mini,nums[p]);
            }
            if(maxi - mini <= k){
                return i;
            }
        }
        return -1;
    }
}