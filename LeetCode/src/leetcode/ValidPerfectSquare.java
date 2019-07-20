package leetcode;

public class ValidPerfectSquare {
    /**
     * https://leetcode.com/problems/valid-perfect-square/description/
     * 367. Valid Perfect Square
     *
     * 1 4 9 16...
     * 3 5 7
     * 平方数间隔
     *利用这个特性
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        int subNum = 1;
        while (num > 0) {
            num -= subNum;
            subNum += 2;
        }
        return num == 0;
    }
}
