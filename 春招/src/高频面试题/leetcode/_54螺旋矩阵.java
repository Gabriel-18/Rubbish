package 高频面试题.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _54螺旋矩阵 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ret;
        }

        int r1 = 0, c1 = 0, r2 = matrix.length - 1, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++) {
                ret.add(matrix[r1][i]);
            }

            for (int i = r1 + 1; i <= r2; i++) {
                ret.add(matrix[i][c2]);
            }

            if (r1 != r2) {
                for (int i = c2 - 1; i >= c1; i--) {
                    ret.add(matrix[r2][i]);
                }
            }

            if (c1 != c2) {
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
}
