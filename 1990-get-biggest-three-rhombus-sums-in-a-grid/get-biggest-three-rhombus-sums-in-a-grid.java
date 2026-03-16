class Solution {
    public int[] getBiggestThree(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        TreeSet<Integer> set = new TreeSet<>((a,b)->b-a);
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m ; j++){
                set.add(grid[i][j]);

                for(int k=1; k < 50; k++){
                    if(i-k < 0 || i+k >= n || j-k <0 || j+k >= m) break;
                    int sum = 0;
                    int r = i-k;
                    int c = j;
                    for(int t= 0; t < k; t++){
                        sum += grid[r+t][c+t];
                    }
                    for(int t=0;t<k;t++){
                        sum += grid[r+k+t][c+k-t];
                    }
                    for(int t =0; t < k; t++){
                        sum += grid[r+2*k-t][c-t];
                    }
                    for(int t=0;t<k;t++){
                        sum += grid[r+k-t][c-k+t];
                    }
                    set.add(sum);
                }
            }
        }
        int size = Math.min(3,set.size());
        int[] res = new int[size];
        int i = 0;
        for(int val : set){
            if(i ==  size) break;
            res[i++] = val;
        }
        return res;
    }
}