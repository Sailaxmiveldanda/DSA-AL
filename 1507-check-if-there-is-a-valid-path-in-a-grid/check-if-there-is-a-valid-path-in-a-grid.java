class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dirs = {{0,-1},{0,1},{-1,0},{1,0}};
        int[][] allowed = {
            {0,1},
            {2,3},
            {0,3},
            {1,3},
            {0,2},
            {1,2}
        };
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            if(r == m-1 && c == n-1){
                return true;
            }
            int type = grid[r][c] - 1;
            for(int d : allowed[type]){
                int nr = r + dirs[d][0];
                int nc = c + dirs[d][1];

                if(nr >= 0 && nr < m && nc >= 0 && nc < n  && !visited[nr][nc]){
                    int nextType = grid[nr][nc] - 1;
                    int opp = d ^ 1;

                    boolean connect =false;
                    for(int nd : allowed[nextType]){
                        if(nd == opp){
                            connect = true;
                            break;
                        }
                    }
                    if(connect){
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr,nc});
                    }
                }
            }
        }
        return false;
    }
}