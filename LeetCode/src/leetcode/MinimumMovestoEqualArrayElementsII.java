package leetcode;

import java.util.Arrays;

/**
 * 462. Minimum Moves to Equal Array Elements II
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/description/
 */
public class MinimumMovestoEqualArrayElementsII {
    /**
     * 有序情况下
     * 典型的相遇问题， 移动距离最小的方式就是移动到中位数
     * a m b
     * m - a m - b
     * b - a
     * 数组长度位N
     * 则可以找到N / 2 对
     *
     * 无序
     * 利用快速选择找到中位数， 需要复习下快排
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


    public int minMoves2a(int[] nums) {
        int move = 0;
        int middle = findKthSmallest(nums, nums.length / 2);
        for (int num : nums) {
            move += Math.abs(num - middle);
        }
        return move;
    }

    private int findKthSmallest(int[] nums, int k) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            }
            if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (nums[++i] < nums[l] && i < h);
            while (nums[--j] > nums[l] && j > l);
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
