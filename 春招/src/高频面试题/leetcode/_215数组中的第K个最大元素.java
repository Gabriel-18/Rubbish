package 高频面试题.leetcode;

public class _215数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        return kQuickSort(nums, 0, nums.length - 1, nums.length + 1 - k);
    }

    private int kQuickSort(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }
        int i = l - 1, j = r + 1, x = nums[(l + r) >> 1];
        while (i < j) {
            while (nums[++i] < x);
            while (nums[--j] > x);
            if (i < j) {
                swap(nums, i,j);
            }
        }
        int leftSize = j - l + 1;
        if (k <= leftSize) {
            return kQuickSort(nums, l, j, k);
        } else {
            return kQuickSort(nums, j + 1, r, k - leftSize);
        }

    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
