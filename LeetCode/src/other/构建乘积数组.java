package other;

public class 构建乘积数组 {
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];

        // 从左往右计算
        for (int i = 0, product = 1; i < n; product *= A[i], i++) {
            B[i] = product;
        }

        // 从右往左计算
        for (int i = n - 1, product = 1; i >= 0; product *= A[i], i--) {
            B[i] *= product;
        }
        return B;
    }
}
