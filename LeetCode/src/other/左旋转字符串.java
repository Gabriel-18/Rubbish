package other;
// 先将 "abc" 和 "XYZdef" 分别翻转，
// 得到 "cbafedZYX"，
// 然后再把整个字符串翻转得到 "XYZdefabc"。
public class 左旋转字符串 {
    public String LeftRotateString(String str,int n) {
        if (n >= str.length()) {
            return str;
        }
        char[] chars = str.toCharArray();
        // 分别翻转
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        // 整体翻转
        reverse(chars, 0, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int i, int j) {
        while (i < j) {
            swap(chars, i++, j--);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }
}
