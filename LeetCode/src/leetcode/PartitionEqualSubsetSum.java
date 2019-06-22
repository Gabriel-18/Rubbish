package leetcode;

public class PartitionEqualSubsetSum {
    /**
     * https://leetcode.com/problems/partition-equal-subset-sum/
     * 416. Partition Equal Subset Sum
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
