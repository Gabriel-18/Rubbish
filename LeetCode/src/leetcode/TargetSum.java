package leetcode;

public class TargetSum {
    /**
     * https://leetcode.com/problems/target-sum/
     * 494. Target Sum
     * @param nums
     * @param S
     * @return
     */
    public int findTargetSumWays(int[] nums, int S) {
        int sum = computeArraySum(nums);
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int w = (sum + S) / 2;

        int[] dp = new int[w + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = w; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
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
