package leetcode;

public class ConvertaNumbertoHexadecimal {
    /**
     * 405. Convert a Number to Hexadecimal
     * https://leetcode.com/problems/convert-a-number-to-hexadecimal/description/'
     *思路： 利用二进制转十六进制的特殊性
     * 每次处理低四位
     * 然后无符号右移
     * @param num
     * @return
     */
    public String toHex(int num) {
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd' ,'e', 'f'};

        if (num == 0) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(map[num & 0b1111]);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
}
