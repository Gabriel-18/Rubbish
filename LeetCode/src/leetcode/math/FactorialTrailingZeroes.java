package leetcode.math;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
    public int trailingZeroes2(int n) {
        int count = 0;
        while (n > 0){
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
