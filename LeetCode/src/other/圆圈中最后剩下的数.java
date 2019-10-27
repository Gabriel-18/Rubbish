package other;

public class 圆圈中最后剩下的数 {
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0) { /* 特殊输入处理 */
            return -1;
        }
        if (n == 1) { /* 递归返回条件 */
            return 0;
        }
        return ((LastRemaining_Solution(n - 1, m)) + m) % n;
    }
}
