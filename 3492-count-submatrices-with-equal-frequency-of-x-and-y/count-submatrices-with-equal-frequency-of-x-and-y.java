class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] px = new int[m][n];
        int[][] py = new int[m][n];

        for(int i = 0; i < m ; i++){
            for(int j = 0; j < n ; j++){
                
                if( i > 0) {
                    px[i][j] += px[i-1][j];
                    py[i][j] += py[i-1][j];
                }

                if(j > 0){
                    px[i][j] += px[i][j-1];
                    py[i][j] += py[i][j-1];
                }
                if(i > 0 && j > 0){
                    px[i][j] -= px[i-1][j-1];
                    py[i][j] -= py[i-1][j-1];
                }

                if(grid[i][j] == 'X') px[i][j]++;
                if(grid[i][j] == 'Y') py[i][j]++;

                if(px[i][j] == py[i][j] && px[i][j] > 0) {
                    count++;
                }
            }
        }
        return count;
    }
}