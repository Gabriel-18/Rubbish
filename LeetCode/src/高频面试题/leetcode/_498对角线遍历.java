package 高频面试题.leetcode;

public class _498对角线遍历 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        int[] answer = new int[rowLength * columnLength];
        int count = rowLength + columnLength - 1;
        int m = 0;
        int n = 0;
        int answerIndex = 0;

        for (int i = 0; i < count; i++) {
            if (i % 2 == 0) {
                while (m >= 0 && n < columnLength) {
                    answer[answerIndex++] = matrix[m][n];
                    m--;
                    n++;
                }
                // m < 0
                if (n < columnLength) {
                    m++;
                } else {
                    // n>=columnLength
                    m = m + 2;
                    n--;
                }
            } else {
                while (m < rowLength && n >= 0) {
                    answer[answerIndex++] = matrix[m][n];
                    m++;
                    n--;
                }
                if (m < rowLength) {
                    n++;
                } else {
                    m--;
                    n = n + 2;
                }

            }
        }
        return answer;


    }
}
