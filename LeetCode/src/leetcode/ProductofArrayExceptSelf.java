package leetcode;

import java.util.Arrays;

public class ProductofArrayExceptSelf {
    /**
     * 238. Product of Array Except Self
     * https://leetcode.com/problems/product-of-array-except-self/description/
     * 分成两步
     * 1. 计算除去自己左边的乘积
     * 2.计算除去自己右边的乘积
     *3. 相乘即可
     * @param nums
     * @return
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] products = new int[n];
        Arrays.fill(products, 1);

        int left = 1;
        for (int i = 1; i < n; i++) {
            left *= nums[i - 1];
            products[i] *= left;
        }

        int right = 1;
        for (int i = n - 2; i >= 0; i--) {
            right *= nums[i+1];
            products[i] *= right;
        }
        return products;
    }
}
