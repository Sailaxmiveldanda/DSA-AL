class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum = 0;
        int maxi =0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            maxi += i * nums[i];
        }
        int max = maxi;
        for(int i = 1; i < n; i++){
            maxi += sum - n * nums[n - i];
            max = Math.max(max, maxi);
        }
        return max;
    }
}