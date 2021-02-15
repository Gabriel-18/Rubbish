package 高频面试题.leetcode;

import java.util.Arrays;

public class _300最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
//        dp[i] 的值代表 nums 前 i 个数字的最长子序列长度
        int[] dp = new int[nums.length];
        int res = 0;
        // dp[i] 所有元素置 1，含义是每个元素都至少可以单独成为子序列
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
