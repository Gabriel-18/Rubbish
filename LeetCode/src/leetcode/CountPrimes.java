package leetcode;

public class CountPrimes {
    /**
     *
     * 埃拉托斯特尼筛法??
     * 204. Count Primes
     * https://leetcode.com/problems/count-primes/description/
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n + 1];
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (notPrimes[i]) {
                continue;
            }
            count++;
            // 从i * i 开始, 因为如果k < i, 那么 k * i 在之前就已经被除去了
            for (long j = (long)(i) * i; j < n; j += i) {
                notPrimes[(int) j] = true;
            }
        }
        return count;
    }
}
