class Solution {
    public int findMin(int[] nums) {
        Arrays.sort(nums);
        int mini = Integer.MAX_VALUE;
        for(int i =0; i < nums.length; i++){
            int s = nums[i];
            mini = Math.min(mini, s);
        }
        return mini;
    }
}