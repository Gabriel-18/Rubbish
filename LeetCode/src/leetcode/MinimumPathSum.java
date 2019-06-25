package leetcode;

public class MinimumPathSum {
    /**
     * 64. Minimum Path Sum
     * https://leetcode.com/problems/minimum-path-sum/description/
     * dp[i][j]表示从00位置到ij位置的最小路径和
     * 从上往下走
     * dp[i][j] = dp[i-1][[j] + m[i][j]
     * 从左往右走
     * dp[i][j] = dp[i][[j-1] + m[i][j]
     * 有两个边界
     * 当i=0时只能向右走 即从左到右
     * 当j=0时只能向下走 即从上到下
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    // 只能从上侧走到该位置
                    dp[j] = dp[j] + grid[i][j];
                } else if (i == 0){
                    // 只能从左侧走到该位置
                    dp[j] = dp[j - 1] + grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
                }
            }
        }
        return dp[n - 1];
    }
}
