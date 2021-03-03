package 高频面试题.leetcode;

/***
 * 我们令 dp[i][j] 是到达 i, j 最多路径
 *
 * 动态方程：dp[i][j] = dp[i-1][j] + dp[i][j-1]
 *
 * 注意，对于第一行 dp[0][j]，或者第一列 dp[i][0]，由于都是在边界，所以只能为 1
 */
public class _62不同路径 {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = 1;
        for (int i = 0; i < m; i++) dp[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
