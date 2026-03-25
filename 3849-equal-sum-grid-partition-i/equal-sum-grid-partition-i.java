class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n= grid[0].length;
        long total = 0;
        for(int[] row : grid){
            for(int val : row){
                total += val;
            }
        }
        if(total % 2 != 0) return false;
        long target = total / 2;
        long currsum = 0;
        for(int i = 0; i < m-1; i++){
            for(int j = 0; j < n ; j++){
                currsum += grid[i][j];
            }
            if(currsum == target) return true;
        }
        currsum =0;
        for(int i = 0; i < n-1 ; i++){
            for(int j = 0; j < m; j++){
                currsum += grid[j][i];
            }
            if(currsum == target) return true;
        }
        return false;
    }
}