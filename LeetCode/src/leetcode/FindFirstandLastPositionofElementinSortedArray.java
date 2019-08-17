package leetcode;

public class FindFirstandLastPositionofElementinSortedArray {
    /**
     * 抽象二分查找模型
     * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     * 34. Find First and Last Position of Element in Sorted Array
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int first = binarySearch(nums, target);
        int last = binarySearch(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{first, Math.max(first, last)};
        }
    }

    private int binarySearch(int[] nums, int target) {
        int l = 0, h = nums.length; // 注意 h 的初始值
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] >= target) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
