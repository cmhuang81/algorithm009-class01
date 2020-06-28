class Solution {
    public int maximalSquare(char[][] matrix) {
        if (null == matrix || 0 == matrix.length 
            || 0 == matrix[0].length) {
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int maxS = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                }
                maxS = Math.max(maxS, dp[i][j]);
            }
        }
        return maxS * maxS;
    }
}