package leetcode;

public class AddBinary {
    /**
     * https://leetcode.com/problems/add-binary/
     * 67. Add Binary
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        // 从字符串高位开始 即数字的最低位
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder str = new StringBuilder();

        while (carry == 1 || i >= 0 || j >= 0) {

            if (i >= 0 && a.charAt(i--) == '1') {
                carry++;
            }

            if (j >= 0 && b.charAt(j--) == '1') {
                carry++;
            }

            // 二进制加法
            str.append(carry % 2);
            carry /= 2;
        }
        return str.reverse().toString();
    }
}
