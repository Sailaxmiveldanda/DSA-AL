class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        //prefix and sufix method
        int n = grid.length;
        int m = grid[0].length;
        int mod = 12345;
        int size = n * m;
        int[] arr = new int[size];
        //step1
        int idx = 0;
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m ; j++){
                arr[idx++] = grid[i][j] % mod;
            }
        }
        //step2
        int[] prefix = new int[size];
        prefix[0] = 1;
        for(int i=1; i < size; i++){
            prefix[i] = (prefix[i-1] * arr[i-1]) % mod;
        }

        //step3
        int[] sufix = new int[size];
        sufix[size-1] = 1;
        for(int i = size-2;i >=0; i--){
            sufix[i] = (sufix[i+1] * arr[i+1]) % mod;
        }
        //result
        int[][] res = new int[n][m];
        idx = 0;
        for(int i = 0; i < size ; i++){
                int val = (prefix[i] * sufix[i]) % mod;
                res[idx/m][idx%m] = val;
                idx++;
        }
        return res;
    }
}