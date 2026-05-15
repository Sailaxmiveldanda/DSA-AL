class Solution {
    public int findMin(int[] nums) {
        // Arrays.sort(nums);
        // int mini = Integer.MAX_VALUE;
        // for(int i =0; i < nums.length; i++){
        //     int s = nums[i];
        //     mini = Math.min(mini, s);
        // }
        // return mini;
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]){
                left = mid +1;
            }
            else{
                right = mid;
            }
        }
        return nums[left];
    }
}