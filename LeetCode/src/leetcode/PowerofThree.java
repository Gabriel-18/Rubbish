package leetcode;

public class PowerofThree {
    /**
     * https://leetcode.com/problems/power-of-three/description/
     * 326. Power of Three
     * @param n
     * @return
     */
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}
