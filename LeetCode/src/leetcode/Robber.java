package leetcode;

public class Robber {
    /**
     * https://leetcode.com/problems/house-robber/description/
     考虑到 dp[i] 只与 dp[i - 1] 和 dp[i - 2] 有关，因此可以只用两个变量来存储 dp[i - 1] 和 dp[i - 2]，
     使得原来的 O(N) 空间复杂度优化为 O(1) 复杂度
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int pre2 = 0, pre1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
    public static int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length < 2) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        //dp[0] = nums[0];
        dp[1] = nums[0];

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
            dp[i - 2] = dp[i - 1];
            dp[i - 1] = dp[i];
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] a = {2,7,9,3,1};
        System.out.println(rob2(a));
    }
}
