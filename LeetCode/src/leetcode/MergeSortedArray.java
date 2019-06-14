package leetcode;

public class MergeSortedArray {
    /**
     * 88. Merge Sorted Array
     * https://leetcode.com/problems/merge-sorted-array/description/
     * 两个数组都是有序
     * 一共分成四种情况
     * 第一个数组处理完
     * 第二个数组处理完
     * 第一个数组的元素大于第二个
     * 第二个数组的元素大于第一个
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int indexMerge = m + n - 1;

        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[indexMerge--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[indexMerge--] = nums1[index1--];
            } else if (nums1[index1] > nums2[index2]) {
                nums1[indexMerge--] = nums1[index1--];
            } else {
                nums1[indexMerge--] = nums2[index2--];
            }
        }
    }
}
