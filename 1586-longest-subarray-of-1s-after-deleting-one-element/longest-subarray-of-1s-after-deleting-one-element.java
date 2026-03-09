class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0;
        int count =0;
        int len = 0;
        for(int i =0; i < nums.length ; i++){
            if(nums[i] == 0) count++;
            while(count > 1){
                if(nums[left] == 0) {
                    count--;
                }
                left++;
            }
            len = Math.max(len,i-left);
        }
        return len;
    }
}