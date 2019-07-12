package leetcode;

public class Base7 {
    /**
     * 504. Base 7
     * https://leetcode.com/problems/base-7/description/
     * @param num
     * @return
     */
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();

        boolean isNegative = num < 0;
        if (isNegative) {
            num = -num;
        }

        while (num > 0) {
            sb.append(num % 7);
            num /= 7;
        }

        String ret = sb.reverse().toString();

        // recover its operator if it is a negative
        return isNegative ? "-" + ret : ret;


        //还有个更快的方法
        //   Returns a string representation of the first argument in the
        //   radix specified by the second argument.
        //return Integer.toString(num, 7);
    }
}
