class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0;
        int j = 0;
        int dist = 0;
        while( i < m && j < n){
            if(nums1[i] <= nums2[j]){
                dist = Math.max(dist , j - i);
                j++;
            }
            else {
                i++;
            }
        }
        return dist;
    }
}