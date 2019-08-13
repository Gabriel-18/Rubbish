package leetcode;

public class NondecreasingArray {
    /**
     * https://leetcode.com/problems/non-decreasing-array/description/
     * 65. Non-decreasing Array
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; i++) {
            // 符合题目要求 跳过这种情况 继续执行
            if (nums[i] >= nums[i - 1]) {
                continue;
            }
            // 存在num[i] < nums[i-1] 所以计数一次
            cnt++;
            // num[i] < num[i-2]的情况下 修改nums[i-1] = nums[i]无效
            if (i - 2 >= 0 && nums[i - 2] > nums[i]) {
                nums[i] = nums[i - 1];
            } else { // 优先这样执行 num[i] = nums[i-1] 可能使得num[i]大于num[i+1]
                nums[i - 1] = nums[i];
            }
         }
         return cnt <= 1;
    }
}
