class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        int[] freq = new int[n+1];
        for(int num : nums){
            if (num > n || num <= 0) {
                return false;
            }
            freq[num]++;
        }
        if(freq[n] != 2){
            return false;
        }
        for(int i = 1; i < n ; i++){
            if(freq[i] != 1){
                return false;
            }
        }
        return true;
    }
}