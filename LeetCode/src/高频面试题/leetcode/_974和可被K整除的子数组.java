package 高频面试题.leetcode;
/***
 * sum[i]=A[0]+A[1]+…+A[i]
 *
 * 某个子数组（如下标从i到j）的和可以表示为
 *
 * A[i]+…+A[j]=sum[j]−sum[i−1]
 *
 * 判断子数组的和能否被 K 整除就等价于判断 (sum[j] - sum[i-1]) mod K == 0
 *
 * 等价于判断sum[j] mod K == sum[i-1] mod K
 *
 * 通常取模运算也叫取余运算，它们返回结果都是余数 .rem 和 mod 唯一的区别在于:
 *
 * 当 x 和 y 的正负号一样的时候，两个函数结果是等同的；
 *
 * 当 x 和 y 的符号不同时，
 *
 * rem 函数结果的符号和 x 的一样，而 mod 和 y 一样。
 *
 */
public class _974和可被K整除的子数组 {
    public int subarraysDivByK(int[] A, int K) {
        int[] map = new int[K];
        // 因为当余数是0的时候，直接满足
        // 有现成的 不用进行做差处理
        map[0] = 1;
        int prefix = 0, res = 0;
        for (int a : A) {
            // java的不是真正的取模操作
            prefix = (a + prefix) % K;
            if (prefix < 0) {
                prefix += K;
            }
            res += map[prefix];
            map[prefix]++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(-3 % 4);
        System.out.println(-3 / 4);
        System.out.println(1 % 4);
    }
}
