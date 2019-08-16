package leetcode;

public class FindMinimuminRotatedSortedArray {
    /**
     * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/solution/
     * 153. Find Minimum in Rotated Sorted Array
     * 在一个有重复元素的数组中查找 key 的最左位置的变式
     * 抽象一下
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] <= nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }
}
