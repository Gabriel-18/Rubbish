package leetcode;

public class MaximumProductofThreeNumbers {
    /**
     * 628. Maximum Product of Three Numbers
     * https://leetcode.com/problems/maximum-product-of-three-numbers/
     * 存在正负数
     * 所以最乘积有两种情况
     * 1. 三个最大值之积
     * 2.两个最小值（可能双负数） 一个最大数之积
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int n : nums) {
            if (n <= min1) {
                min2 = min1;
                min1 = n;
            } else if (n <= min2) {
                min2 = n;
            }

            if (n >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n >= max2) {
                max3 = max2;
                max2 = n;
            } else if (n >= max3) {
                max3 = n;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }
}
