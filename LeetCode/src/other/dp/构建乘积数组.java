package other.dp;

import org.junit.Test;
// 把这个计算拆成两步
// 第一次只算除开当前数前面的乘积
// 第二次只计算除开当前数后面的乘积
// 具体过程可以debug
public class 构建乘积数组 {

    @Test
    public void test() {
        multiply(new int[]{1, 2, 3, 4, 5});

    }
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];

        // 从左往右计算
        // for 语法巧妙使用
        for (int i = 0, product = 1; i < n; product *= A[i], i++) {
            B[i] = product;
            System.out.println(B[i]);
        }

        System.out.println("_____________________________");
        // 从右往左计算
        for (int i = n - 1, product = 1; i >= 0; product *= A[i], i--) {
            B[i] *= product;
            System.out.println(B[i]);
        }
        return B;
    }
}
