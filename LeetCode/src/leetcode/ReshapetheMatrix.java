package leetcode;

public class ReshapetheMatrix {
    /**
     * 566. Reshape the Matrix
     * https://leetcode.com/problems/reshape-the-matrix/description/
     * 类似先降维
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }

        int[][] reshshapedNums = new int[r][c];
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j ++) {
                reshshapedNums[i][j] = nums[index / n][index % n];
                index ++;
            }
        }
        return reshshapedNums;
    }
}
