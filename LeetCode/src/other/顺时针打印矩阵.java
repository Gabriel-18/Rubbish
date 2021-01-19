package other;

import java.util.ArrayList;

public class 顺时针打印矩阵 {
    ArrayList<Integer> ret = new ArrayList<Integer>();
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int r1 = 0, c1 = 0, r2 = matrix.length - 1, c2 = matrix[0].length - 1;

        while (r1 <= r2 && c1 <= c2) {
            // 从左到右 c1 - c2
            for (int i = c1; i <= c2; i++) {
                ret.add(matrix[r1][i]);
            }
            //从右上到下 r1 + 1 - r2
            for (int i = r1 + 1; i <= r2; i++) {
                ret.add(matrix[i][c2]);
            }
            //从右到左 c2 - 1 - c1
            if (r1 != r2) {
                for (int i = c2 - 1; i >= c1; i--) {
                    ret.add(matrix[r2][i]);
                }
            }
            //从左下到上 r2 - 1 - r1 -1
            if (c1 != c2) {
                // 确实能走的路会少一格
                for (int i = r2 - 1; i > r1; i--) {
                    ret.add(matrix[i][c1]);
                }
            }
            r1++;
            r2--;
            c1++;
            c2--;
            }
            return ret;
    }
        // leetcode
    public int[] spiralOrder(int[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int r1 = 0, c1 = 0;
        int k = 0;
        int r2 = matrix.length - 1, c2 = matrix[0].length - 1;
        int[] ret = new int[(r2 + 1) * (c2 + 1)];
        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++) ret[k++] = matrix[r1][i];
            for (int i = r1 + 1; i <= r2; i++) ret[k++] = matrix[i][c2];
            if (r1 != r2) {
                for (int i = c2 - 1; i >= c1; i--) ret[k++] = matrix[r2][i];
            }
            if (c1 != c2) {
                for (int i = r2 - 1; i > r1; i--) ret[k++] = matrix[i][c1];
            }
            r1++;
            c1++;
            r2--;
            c2--;
        }
        return ret;
    }
}
