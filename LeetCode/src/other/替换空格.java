package other;

import org.junit.Test;

public class 替换空格 {
    @Test
    public void test() {
        StringBuffer stringBuffer = new StringBuffer("A B");
        replaceSpace(stringBuffer);
    }
    public String replaceSpace(StringBuffer str) {
        int P1 = str.length() - 1;
        for (int i = 0; i <= P1; i++) {
            // 每当出现一个空格
            if (str.charAt(i) == ' ') {
                // 在后面补两个空格
                str.append("  ");
            }
        }
        // 新的字符串末尾
        int P2 = str.length() - 1;
        while (P1 >= 0 && P2 > P1) {
            // p1-- 先赋值后--
            char c = str.charAt(P1--);
            if (c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                // c != ' '
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
     }



}
