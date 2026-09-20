class Solution {
    public int reverseDegree(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            int reverse = 26 - (s.charAt(i) - 'a');
            res += reverse * (i+1);
        }
        return res;
    }
}