class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int left = 0;
        int right = n - 1;
        while(colors[0] == colors[right]){
            right--;
        }
        int d1 = right;
        while(colors[n-1] == colors[left]){
            left++;
        }
        int d2 = (n-1) - left;
        return Math.max(d1,d2);
    }
}