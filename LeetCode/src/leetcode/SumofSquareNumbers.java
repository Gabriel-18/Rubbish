package leetcode;

public class SumofSquareNumbers {
    /**
     * 双指针
     * https://leetcode.com/problems/sum-of-square-numbers/
     * 633. Sum of Square Numbers
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int powSum = i * i + j * j;
            if (powSum == c) {
                return true;
            } else if (powSum > c) {
                j --;
            } else {
                j ++;
            }
        }
        return false;
    }
}
