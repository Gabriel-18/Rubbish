package 高频面试题.leetcode;

import java.util.Arrays;

/**
 * dp[j]：凑足总额为j所需钱币的最少个数为dp[j]
 *
 * 得到dp[j]（考虑coins[i]），只有一个来源，dp[j - coins[i]]（没有考虑coins[i]）。
 *
 * 凑足总额为j - coins[i]的最少个数为dp[j - coins[i]]，那么只需要加上一个钱币coins[i]即dp[j - coins[i]] + 1就是dp[j]（考虑coins[i]）
 *
 * 所以dp[j] 要取所有 dp[j - coins[i]] + 1 中最小的。
 *
 * 递推公式：dp[j] = min(dp[j - coins[i]] + 1, dp[j]);
 *
 *
 * 首先凑足总金额为0所需钱币的个数一定是0，那么dp[0] = 0;
 *
 * 其他下标对应的数值呢？
 *
 * 考虑到递推公式的特性，dp[j]必须初始化为一个最大的数，否则就会在min(dp[j - coins[i]] + 1, dp[j])比较的过程中被初始值覆盖。
 *
 * 所以下标非0的元素都是应该是取不到的大值。
 。

 */
public class _322零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) { // 遍历物品
            for (int j = coins[i]; j <= amount; j++) { // 变量背包
                if (dp[j - coins[i]] != amount + 1) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
