package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ToeplitzMatrix {
    /***
     * https://leetcode.com/problems/toeplitz-matrix/description/
     * It turns out two coordinates are on the same diagonal
     * if and only if r1 - c1 == r2 - c2.
     * 766. Toeplitz Matrix
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        Map<Integer, Integer> groups = new HashMap<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                // 保存在同一条对角线上的元素
                if (!groups.containsKey(r - c)) {
                    groups.put(r - c, matrix[r][c]);
                    // 检验下一个在对角线上的元素
                } else if (groups.get(r - c) != matrix[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isToeplitzMatrix2(int[][] matrix) {
        Map<Integer, Integer> groups = new HashMap<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                //比较上一个对角线上的元素和当前的值
                if (r > 0 && c > 0 && matrix[r - 1][c - 1] != matrix[r][c]) {
                    return false;
                }
            }
        }
        return true;
    }
}
