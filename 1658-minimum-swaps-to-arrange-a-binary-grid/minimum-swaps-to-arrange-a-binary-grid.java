class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] trailing0 = new int[n];
        //step 1 - caluxlte the trailingzeros
        for(int i = 0; i < n ; i++) {
            int count = 0;
            for(int j = n-1; j >= 0 ; j--){
                if(grid[i][j] == 0) count++;
                else break;
            }
            trailing0[i] = count;
        }
        //step 2 - swapping the rows
        int swap = 0;
        for(int i = 0; i < n ; i++){
            int require0 = n - i - 1;
            if(trailing0[i] >= require0) continue;
            int j = i+1;
            while(j < n && trailing0[j] < require0){
                j++;
            }
            if(j == n) return -1;
            while(j > i){
                int temp = trailing0[j];
                trailing0[j] =trailing0[j-1];
                trailing0[j-1] = temp;
                swap++;
                j--;
            }
        }
        return swap;
    }
}