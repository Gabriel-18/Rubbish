package spring;

public class 数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            // 位置没放对
            while (nums[i] != i) {
                // 当前拥有的萝卜 居然在别的坑里面也中的有
                // 及说明重复了
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
