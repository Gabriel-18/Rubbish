package leetcode;

public class HouseRobber {
    /**
     * 198. House Robber
     * https://leetcode.com/problems/house-robber/description/
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
}