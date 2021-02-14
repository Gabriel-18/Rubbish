package 高频面试题.leetcode;

public class 剑指Offer21调整数组顺序使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        int cnt = 0;
        int[] clone = nums.clone();
        for (int a : nums) {
            if (a % 2 == 1) {
                cnt++;
            }
        }

        int i = 0, j = cnt;
        for (int num : clone) {
            if (num % 2 == 1) {
                nums[i++] = num;
            } else {
                nums[j++] = num;
            }
        }
        return nums;
    }
}
