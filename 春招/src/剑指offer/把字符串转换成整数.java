package 剑指offer;

public class 把字符串转换成整数 {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean isNegative = str.charAt(0) == '-';
        int ret = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && (c == '+' || c == '-')) { /**符号判定**/
                continue;
            }
            if (c < '0' || c > '9' || c > Integer.MAX_VALUE) { /*非法输入*/
                return 0;
            }
            ret = ret * 10 + (c - '0');
        }
        return isNegative ? -ret : ret;
    }
}
