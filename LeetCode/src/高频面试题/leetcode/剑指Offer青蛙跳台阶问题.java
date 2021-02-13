package 高频面试题.leetcode;

public class 剑指Offer青蛙跳台阶问题 {
    public int numWays(int n) {
        int[] dp = new int[n + 1];
        if (n <= 1) {
            return 1;
        }
        dp[0] = 1; dp[1] = 1; dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}
