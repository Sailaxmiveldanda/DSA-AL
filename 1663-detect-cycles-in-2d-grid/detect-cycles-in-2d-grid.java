class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, visited, i, j, -1, -1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] visited,
                        int x, int y, int px, int py) {

        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length)
                continue;

            if (grid[nx][ny] != grid[x][y])
                continue;

            if (!visited[nx][ny]) {
                if (dfs(grid, visited, nx, ny, x, y))
                    return true;
            }
            else if (nx != px || ny != py) {
                return true;
            }
        }
        return false;
    }
}