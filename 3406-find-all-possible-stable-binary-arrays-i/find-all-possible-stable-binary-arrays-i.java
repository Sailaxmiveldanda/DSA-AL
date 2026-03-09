class Solution {
    int mod = 1000000007;
   // Integer[][][][] dp;
   Integer[][][] dp;
    public int numberOfStableArrays(int zero, int one, int limit) {
        dp = new Integer[zero+1][one+1][2];
        for(int i = 0; i <= zero;i++){
            for(int j = 0; j <= one; j++){
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }
        int startwithzero = dfs(zero,one,0,limit);
        int startwithone = dfs(zero,one,1,limit);
        return (startwithzero + startwithone) % mod;
    }

    private int dfs(int z, int o, int last,int limit){
        if(z == 0 && o == 0) return 1;
        if(z < 0 || o < 0) return 0;
        long ans = 0;
        if(dp[z][o][last] != -1) return dp[z][o][last];
        if(last == 0){
            for(int i = 1; i <= Math.min(o,limit); i++){
                ans = (ans + dfs(z,o-i,1,limit)) % mod;
            }
        }
        else {
            for(int i = 1; i <= Math.min(z,limit);i++){
                ans = (ans + dfs(z-i,o,0,limit)) % mod;
            }
        }
        // if(z > 0){
        //     if(last == 0){
        //         if(count < limit){
        //             ans += dfs(z-1,o,0,count+1,limit);
        //         }
        //     }
        //     else{
        //         ans += dfs(z-1,o,0,1,limit);
        //     }
        // }
        // if(o > 0){
        //     if(last ==1){
        //         if(count < limit){
        //             ans += dfs(z,o-1,1,count+1,limit);
        //         }
        //     }
        //     else{
        //         ans += dfs(z,o-1,1,1,limit);
        //     }
        // }
        return dp[z][o][last] = (int) ans;
    }
}