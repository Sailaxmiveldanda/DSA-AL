class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int elements = m * n ;
        int[] nums = new int[elements];
        int index = 0;
        for(int i = 0; i <m ; i++){
            for(int j = 0; j < n ; j++){
                nums[index++] = grid[i][j];
            }
        }
        for(int i = 1; i < elements ; i++){
            if(Math.abs(nums[i] - nums[0]) % x != 0){
                return -1;
            }
        }
        Arrays.sort(nums);
        int median = nums[elements/2];
        int op = 0;
        for(int num : nums){
            op += Math.abs(num - median) / x;
        }
        return op;
    }
}