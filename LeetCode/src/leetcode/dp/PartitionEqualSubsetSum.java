package leetcode.dp;

public class PartitionEqualSubsetSum {
    /**
     * https://leetcode.com/problems/partition-equal-subset-sum/
     * 416. Partition Equal Subset Sum
     * 可以看成一个背包大小为 sum/2 的 0-1 背包问题。
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = computeArraySum(nums);
        if (sum % 2 != 0) {
            return false;
        }
        int w = sum / 2;
        boolean[] dp = new boolean[w + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = w; i >= num; i--) {
                // 不能凑出和能凑出
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[w];
    }

    private int computeArraySum(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
