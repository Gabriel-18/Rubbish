package leetcode;

public class SingleElementinaSortedArray {
    /**
     * https://leetcode.com/problems/single-element-in-a-sorted-array/
     * 540. Single Element in a Sorted Array
     *
     *
     * First we can know that the index of single element must be even
     *
     * since the number of elements before the single element is 2*c.
     *
     * For the elements to the left of the single element in nums:
     *
     * For odd index i, nums[i] = nums[i - 1];
     * For even inedx i, nums[i] = nums[i + 1];
     * For example:
     *
     *  0  1  2  3  4
     * [1  1  3  5  5]
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
