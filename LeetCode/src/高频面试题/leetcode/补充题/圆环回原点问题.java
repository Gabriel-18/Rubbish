package 高频面试题.leetcode.补充题;

public class 圆环回原点问题 {
    public static int backToOrigin(int n){
        // 点的个数
        int length = 10;
        int[][] dp = new int[n + 1][length];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < length; j++) {
//                 dp[i][j]表示从0出发，走i步到j的方案数
                dp[i][j] = dp[i - 1][(j - 1 + length) % length] + dp[i - 1][(j + 1) %length];
            }
        }
        // 0 1 0
        // 0 9 0
        return dp[n][0];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 11; i++){
            System.out.println(i +" "+backToOrigin(i) + " steps");
        }
    }

}
