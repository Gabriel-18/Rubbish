package leetcode;

public class ExcelSheetColumnTitle {
    /**
     * https://leetcode.com/problems/excel-sheet-column-title/description/
     * 168. Excel Sheet Column Title
     * 十进制转二十六进制
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        if (n == 0) {
            return "";
        }
        // 因为是从1开始计算的，而不是从0，所以要对n-1操作
        n--;
        return convertToTitle(n / 26) + (char)(n % 26 + 'A');
    }

    public String convertToTitle2(int n) {
        if (n == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            // 从1开始，不是从0
            n--;
            char ch = (char) (n % 26 + 'A');
            sb.append(ch);
            n /= 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
