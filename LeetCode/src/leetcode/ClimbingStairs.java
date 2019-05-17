package leetcode;

public class ClimbingStairs {
    /**
     * https://leetcode.com/problems/climbing-stairs/
     * 本质就是斐波那契数列
     * 为啥我这个会超时呢????????
     * @param n
     * @return
     */

    public static int climbStairs(int n) {
        int[] dp = new int[Integer.MAX_VALUE];
        if (n <= 2) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        } else {
            dp[n] = climbStairs(n - 1) + climbStairs(n - 2);
            return dp[n];
        }
    }

    /**
     * 画图
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
    public static void main(String[] args) {
        System.out.println(climbStairs2(38));
        //System.out.println(climbStairs2(45));
    }
}
