package 剑指offer.dp;

import java.util.Arrays;
// fn = fn-1 + fn-2 + ... + f0
public class 变态跳台阶 {
    public int JumpFloorII(int target) {
        int[] dp = new int[target];
        //初始化每一种都可以直接从 0 跳到 n - 1
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++) {
            for (int j = 0; j < i; j++) {
                // 第 n 个状态是由前 n - 1 种状态推导出来，就是累加
                dp[i] += dp[j];
            }
        }
        return dp[target - 1];
    }
}
