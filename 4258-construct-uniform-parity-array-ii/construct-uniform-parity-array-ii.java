class Solution {
    public boolean uniformArray(int[] nums1) {
        int min = Integer.MAX_VALUE;
        for(int num : nums1) {
            if(num < min) {
                min = num;
            }
        }
        if((min&1) == 1) {
            return true;
        }
        for(int num : nums1) {
            if((num&1) == 1) {
                return false;
            }
        }
        return true;
    }
}