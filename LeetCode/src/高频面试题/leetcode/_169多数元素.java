package 高频面试题.leetcode;

/**
 * 候选人(cand_num)初始化为nums[0]，票数count初始化为1。
 * 当遇到与cand_num相同的数，则票数count = count + 1，否则票数count = count - 1。
 * 当票数count为0时，更换候选人，并将票数count重置为1。
 * 遍历完数组后，cand_num即为最终答案。
 */
public class _169多数元素 {
    class Solution {
        public int majorityElement(int[] nums) {
            int candidate = nums[0], count = 1;
            for (int i = 1; i < nums.length; ++i) {
                if (candidate == nums[i]){
                    count++;
                } else if (--count == 0) {
                    candidate = nums[i];
                    count = 1;
                }
            }
            return candidate;
        }
    }
}
