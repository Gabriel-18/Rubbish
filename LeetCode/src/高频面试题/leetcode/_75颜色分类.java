package 高频面试题.leetcode;

public class _75颜色分类 {
    public void sortColors(int[] nums) {
        int zero = -1, one = 0, two = nums.length;
        while (one < two) {
            if (nums[one] == 1) {
                one++;
            } else if (nums[one] == 0) {
                swap(nums,++zero, one++);
            } else {
                swap(nums, --two, one);
            }
        }
    }
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
