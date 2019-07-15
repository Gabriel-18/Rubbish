package leetcode;

public class FactorialTrailingZeroes {
    /**
     * https://leetcode.com/problems/factorial-trailing-zeroes/description/
     * 172. Factorial Trailing Zeroes
     * 0 只能由 2 * 5 得到  2 的数量比5多
     * 因此只需要求出5的个数
     * 个数应该是 n / 5 + n / 5 ^2 + n / 5 ^ 3 + ......
     * 1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 11 * 12 * 13 * 14 * 15 * 16 * 17 * 18 * 19 * 20 * 21 * 22 * 23 * 24 * 25 * .......
     * 可以参考下这个
     * https://leetcode.com/problems/factorial-trailing-zeroes/discuss/334090/0ms-c%2B%2B-solution-with-SUPER-intuitive-explaination
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}
