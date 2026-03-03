class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while(left < right){
            int width = right - left;
            int heights = Math.min(height[left],height[right]);
            int k = width * heights;
            max = Math.max(max,k);
            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
    }
}