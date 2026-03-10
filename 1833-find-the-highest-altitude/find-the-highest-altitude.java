class Solution {
    public int largestAltitude(int[] gain) {
        int current = 0;
        int maxi = 0;
        for(int g : gain){
            current += g;
            maxi = Math.max(maxi,current);
        }
        return maxi;
    }
}