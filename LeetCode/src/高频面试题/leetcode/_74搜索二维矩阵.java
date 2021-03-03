package 高频面试题.leetcode;

public class _74搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null) return true;
        int m = matrix.length, n = matrix[0].length;
        int r = 0, c = n - 1;
        while (r < m && c >= 0) {
            int x = matrix[r][c];
            if (x == target) {
                return true;
            } else if  (x > target) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }
}
