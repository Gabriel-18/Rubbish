package leetcode;

import java.util.Arrays;

/**
 * 462. Minimum Moves to Equal Array Elements II
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/description/
 */
public class MinimumMovestoEqualArrayElementsII {
    /**
     * 典型的相遇问题， 移动距离最小的方式就是移动到中位数
     * a m b
     * m - a m - b
     * b - a
     * 数组长度位N
     * 则可以找到N / 2 对
     * @param nums
     * @return
     */
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int move = 0;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            move += nums[h] - nums[l];
            l++;
            h--;
        }
        return move;
    }
}
