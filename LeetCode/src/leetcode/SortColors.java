package leetcode;

public class SortColors {
    /***
     * https://leetcode.com/problems/sort-colors/description/
     * 75. Sort Colors
     * 注意
     * zero指针肯定是要指向最后一个zero 向右跑
     * two指针肯定是要指向第一个two 向左跑
     * one应该也是指向最后一个one 顺势向右
     * 大概是三路快排的部分实现
     * @param nums
     */
    public void sortColors(int[] nums) {
        //注意初始位置划分
        int zero = -1, one = 0, two = nums.length;
        // 要理解清楚 这个交换过程 感觉写不出来....
        while (one < two) {
            if (nums[one] == 0) { // zero的范围直接就扩大1 one事后变化
                swap(nums, ++zero, one++);
            } else if (nums[one] == 2) { // two范围扩大 one事后不变化 这个我倒是不清楚了....
                swap(nums, --two, one);
            } else { // 指向了one 可以前进一步
                ++one;
            }
        }
    }

    // 最基础的交换
    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
