package leetcode;

public class SingleElementinaSortedArray {
    /**
     * https://leetcode.com/problems/single-element-in-a-sorted-array/
     * 540. Single Element in a Sorted Array
     * @param nums
     * @return
     */
    public int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (m % 2 == 1) {
                m--; // l / h / m 都在偶数位 使得查找区间大小为奇数
            }
            if (nums[m] == nums[m + 1]) {
                l = m + 2;
            } else {
                h = m;
            }
        }
        return nums[l];
    }
}
