class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int profict =0;
        for(int price : prices){
            minPrice = Math.min(minPrice, price);
            profict = Math.max(profict, price - minPrice);
        }
        return profict;
    }
}