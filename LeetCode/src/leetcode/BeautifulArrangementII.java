package leetcode;

public class BeautifulArrangementII {
    /**
     * 让前 k+1 个元素构建出 k 个不相同的差值，
     * 序列为：1 k+1 2 k 3 k-1 ... k/2 k/2+1.
     *667. Beautiful Arrangement II
     * https://leetcode.com/problems/beautiful-arrangement-ii/
     * @param n
     * @param k
     * @return
     */
    public int[] constructArray(int n, int k) {
        int[] ret = new int[n];
        ret[0] = 1;

        for (int i = 1, interval = k; i <= k; i++, interval --) {
            ret[i] = i % 2 == 1 ? ret[i - 1] + interval : ret[i - 1] - interval;
        }

        // 剩余部分
        for (int i = k + 1; i < n; i++) {
            ret[i] = i + 1;
        }
        return ret;
    }
}
