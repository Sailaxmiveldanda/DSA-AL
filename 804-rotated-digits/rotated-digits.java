class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for(int i = 1; i <= n ; i++){
            if(isgood(i)) count++;
        }
    return count;
    }
    private boolean isgood(int num){
        boolean diff = false;
        while ( num > 0){
            int d = num % 10;
            if (d == 3 || d == 4 || d == 7) return false;
            if(d == 2 || d == 5 || d ==6 || d == 9) diff = true;
            num /= 10;
        }
        return diff;
    }

}
    // public int rotatedDigits(int n) {
    //     int[] dp = new int[n + 1];
    //     int count = 0;

    //     for (int i = 0; i <= n; i++) {
    //         if (i < 10) {
    //             if (i == 0 || i == 1 || i == 8) {
    //                 dp[i] = 1;
    //             } else if (i == 2 || i == 5 || i == 6 || i == 9) {
    //                 dp[i] = 2;
    //                 count++;
    //             } else {
    //                 dp[i] = 0;
    //             }
    //         } else {
    //             int a = dp[i / 10];
    //             int b = dp[i % 10];

    //             if (a == 1 && b == 1) {
    //                 dp[i] = 1;
    //             } else if (a >= 1 && b >= 1) {
    //                 dp[i] = 2;
    //                 count++;
    //             } else {
    //                 dp[i] = 0;
    //             }
    //         }
    //     }

    //     return count;
    // }