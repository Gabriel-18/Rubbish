package 高频面试题.leetcode;

public class 剑指Offer42连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preSum = 0;
        int max = -101;
        for (int i = 0; i < nums.length; i++) {
            preSum = preSum < 0 ? nums[i] : preSum + nums[i];
            max = Math.max(preSum, max);
        }
        return max;

    }
}
