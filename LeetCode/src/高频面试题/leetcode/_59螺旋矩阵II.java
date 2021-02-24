package 高频面试题.leetcode;

public class _59螺旋矩阵II {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[][]{};
        }
        int[][] ret = new int[n][n];
        int r1 = 0, c1 = 0, r2 = n - 1, c2 = n - 1;
        int num = 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int i = c1; i <= c2; i++) {
                ret[r1][i] = num++;
            }

            for (int i = r1 + 1; i <= r2; i++) {
                ret[i][c2] = num++;
            }

            if (r1 != r2) {
                for (int i = c2 - 1; i >= c1; i--) {
                    ret[r2][i] = num++;
                }
            }

            if (c1 != c2) {
                for (int i = r2 - 1; i > r1; i--) {
                    ret[i][c1] = num++;
                }
            }
            r1++;
            c1++;
            r2--;
            c2--;
        }

        return ret;
    }
}
