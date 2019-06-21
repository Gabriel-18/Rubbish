package leetcode;

public class ClimbingStairs {
    /**
     * https://leetcode.com/problems/climbing-stairs/
     * 70. Climbing Stairs
     * 本质就是斐波那契数列
     * 为啥我这个会超时呢????????
     * @param n
     * @return
     */

    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        // 边界
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /**
     * 一样是斐波那契数列
     * @param n
     * @return
     */
    public static   int climbStairs2(int n) {
        if (n <= 1) return 1;
        int oneStep = 1, twoStep = 1, res = 0;
        for (int i = 2; i <= n; i ++) {
            // 两种可能性
            res = oneStep + twoStep;
            twoStep = oneStep;
            oneStep = res;
        }
        return res;
    }

    /**
     * 利用斐波那契数列规律
     * 感觉不算动态规划
     * @param n
     * @return
     */
    public int climbStairs3(int n) {
        if (n <= 2) {
            return n;
        }
        // dp[i - 1] dp[i - 2]
        int pre2 = 1, pre1 = 2;
        for (int i = 2; i < n; i++) {
            int cur = pre1 + pre2;
            // 前进
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
    public static void main(String[] args) {
        System.out.println(climbStairs2(38));
        //System.out.println(climbStairs2(45));
    }
}
