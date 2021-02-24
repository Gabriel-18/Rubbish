package 高频面试题.leetcode;

public class _509斐波那契数 {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int pre1 = 0, pre2 = 1, sum = 1;
        for (int i = 2; i <= n; i++) {
            sum = pre1 + pre2;
            pre1 = pre2;
            pre2 = sum;
        }
        return sum;
    }
}
