package leetcode.array;

public class ReshapetheMatrix {
    // 1. 判断能不能转
    // 2. 怎么转
    // 3. 一维化
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length, m = nums[0].length;
        // 不合法
        if (n * m != r * c) {
            return nums;
        }
        // 新数组
        int[][] reshapeNums = new int[r][c];
        // 一维信息统计
        int index = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 二维化
                // m 每行有多少个
                // 是靠这个把他拉直的
                reshapeNums[i][j] = nums[index / m][index % m];
                index++;
            }
        }
        return reshapeNums;
    }
}
