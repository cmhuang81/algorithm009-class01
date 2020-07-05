class Solution {
    public int numIslands(char[][] grid) {
        int numOfIsland = 0;
        int rows = grid.length;
        if (0 == rows) {
            return 0;
        }
        int cols = grid[0].length;
        if (0 == cols) {
            return 0;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    ++ numOfIsland;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }
        return numOfIsland;
    }

    private void dfs(char[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j, rows, cols);
        dfs(grid, i + 1, j, rows, cols);
        dfs(grid, i, j + 1, rows, cols);
        dfs(grid, i, j - 1, rows, cols);
    }
}