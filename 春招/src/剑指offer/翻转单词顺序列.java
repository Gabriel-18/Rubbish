package 剑指offer;
// 先翻转每个单词，再翻转整个字符串。
// 判断什么时候能翻转 j指针超过字符串一位
public class 翻转单词顺序列 {

    public String reverseWords(String s) {
        int n = s.length();
        int i1 = 0, j1 = 0;
        char[] chars = s.toCharArray();
        int i = 0, j = 0;
        while (i <= n) {
            if (j == n || chars[j] == ' ') {
                reverse(chars, i, j - 1);
                i = j + 1;
            }
            j++;
        }
        reverse(chars, 0, n - 1);
        return new String(chars).trim();
    }




    public String ReverseSentence(String str) {
        int n = str.length();
        // 转成数组
        char[] chars = str.toCharArray();

        int i = 0, j = 0;
        // 针对单个单词进行翻转
        while (j <= n) {
            // 1. 走完了整个字符串
            // 2， 走完了单个单词
            if (j == n || chars[j] == ' ') {
                // 翻转
                reverse(chars, i, j - 1);
                // 更新i pointer
                i = j + 1;
            }
            // 更新j pointer
            j++;
        }
        // 整个字符串进行翻转
        reverse(chars, 0, n - 1);
        return new String(chars);
    }

    //
    private void reverse(char[] c, int i, int j) {
        while (i < j) {
            swap(c, i++, j--);
        }
    }

    // 交换函数
    private void swap(char[] c, int i, int j) {
        char t = c[i];
        c[i] = c[j];
        c[j] = t;
    }


}
