class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length;
        int n = coins[0].length;
        int[][][] dp = new int[m][n][3];
        int min = Integer.MIN_VALUE / 2;
        for(int i = 0; i <m ; i++){
            for(int j = 0; j < n ; j++){
                dp[i][j][0] = min;
                dp[i][j][1] = min;
                dp[i][j][2] = min;
            }
        }
        dp[0][0][0] = coins[0][0];
        if(coins[0][0] < 0){
            dp[0][0][1] = 0;
        }
        for(int  i =0; i < m ; i++){
            for(int j =0; j < n ; j++){
                if(i == 0 && j == 0) continue;
                for(int k = 0; k < 3 ; k++){
                    int prevmax = min;
                    if(i > 0) prevmax = Math.max(prevmax, dp[i-1][j][k]);
                    if(j > 0) prevmax = Math.max(prevmax, dp[i][j-1][k]);
                    if(prevmax != min){
                        dp[i][j][k] = prevmax + coins[i][j];
                    }
                    if(coins[i][j] < 0 && k > 0){
                        int prev = min;
                        if(i>0) prev = Math.max(prev, dp[i-1][j][k-1]);
                        if(j>0) prev = Math.max(prev,dp[i][j-1][k-1]);
                        if(prev != min){
                            dp[i][j][k] = Math.max(dp[i][j][k], prev);
                        }
                    }
                }
            }
        }
        return Math.max(dp[m-1][n-1][0], Math.max(dp[m-1][n-1][1], dp[m-1][n-1][2]));
    }
}