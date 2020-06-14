class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        int nr = grid.length;
        if (0 == nr) return 0;
        int nc = grid[0].length;
        if (0 == nc) return 0;

        for (int r = 0; r < nr; r ++) {
            for (int c = 0; c < nc; c ++) {
                if (grid[r][c] == '1') {
                    ++numIslands;
                    dfs(grid, r, c, nr, nc);
                }
            }
        }

        return numIslands;
    }
    private void dfs (char[][] grid, int r, int c, int nr, int nc) {
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0' 
            || grid[r][c] == '2') {
            return;
        }

        grid[r][c] = '2';

        dfs(grid, r - 1, c, nr, nc);
        dfs(grid, r + 1, c, nr, nc);
        dfs(grid, r, c - 1, nr, nc);
        dfs(grid, r, c + 1, nr, nc);
    }
}