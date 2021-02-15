package 高频面试题.leetcode;

/***
 * dp[j]：凑成总金额j的货币组合数为dp[j]
 *
 * dp[j] （考虑coins[i]的组合总和） 就是所有的dp[j - coins[i]]（不考虑coins[i]）相加。
 *
 * 所以递推公式：dp[j] += dp[j - coins[i]];
 *
 * 求装满背包有几种方法，一般公式都是：dp[j] += dp[j - nums[i]];
 *
 * 首先dp[0]一定要为1，dp[0] = 1是 递归公式的基础。
 *
 * 从dp[i]的含义上来讲就是，凑成总金额0的货币组合数为1。
 *
 * 下标非0的dp[j]初始化为0，这样累计加dp[j - coins[i]]的时候才不会影响真正的dp[j]
 */
public class _518零钱兑换II {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) { // 遍历物品
            for (int j = coins[i]; j <= amount; j++) { // 遍历背包
                dp[j] += dp[j - coins[i - 1]];
            }
        }
        return dp[amount];
    }
}
