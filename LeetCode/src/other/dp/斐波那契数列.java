package other.dp;

public class 斐波那契数列 {
    // 0 1 1 2 3 5
    public int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int[] fib = new int[n + 1];
        // update
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    // 优化
    // 第i项 与 第i-1 和 i-2
    public int Fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }
        int pre1 = 0, pre2 = 1;
        int fib = 0;
        for (int i = 2; i <= n; i++) {
            fib = pre2 + pre1;
            pre1 = pre2;
            pre2 = fib;
        }
        return fib;
    }
}
