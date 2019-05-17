package leetcode;

/**
 * https://leetcode.com/problems/rotate-image/
 * 做两次变换
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        /**
         * 第一次变换
         * 基础变换还是有点不清楚
         */
        for (int i = 0; i < matrix.length; i ++) {
            for (int j = i + 1;j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        /**
         * 第二次变换
         */
        for (int i = 0;i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j ];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }
}
