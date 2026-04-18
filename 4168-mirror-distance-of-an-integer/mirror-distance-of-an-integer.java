class Solution {
    public int mirrorDistance(int n) {
        int reversedigit = reverse(n);
        return Math.abs(n - reversedigit);
    }
    private int reverse(int n){
        int rev = 0;
        while(n != 0){
            int x = n % 10;
            rev = rev * 10 + x;
            n = n / 10;
        }
        return rev;
    }
}