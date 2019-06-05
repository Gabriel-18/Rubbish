package leetcode;

public class MaxConsecutiveOnes {
    /**
     *https://leetcode.com/problems/max-consecutive-ones/description/
     * 485. Max Consecutive Ones
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cur = 0;
        for (int x : nums) {
            cur = x == 0 ? 0 : cur + 1;
            max = Math.max(max, cur);
        }
        return max;
    }
}
