package 高频面试题.leetcode;

public class _55跳跃游戏 {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxJump) return false;
            maxJump = Math.max(maxJump, i + nums[i]);
        }
        return true;
    }
}
