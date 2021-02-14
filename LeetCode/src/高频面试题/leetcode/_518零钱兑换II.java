package 高频面试题.leetcode;

public class _518零钱兑换II {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = coins[i - 1]; j <= amount; j++) {
                dp[j] += dp[j - coins[i - 1]];
            }
        }
        return dp[amount];
    }
}
