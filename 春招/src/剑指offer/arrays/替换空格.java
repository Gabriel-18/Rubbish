package 剑指offer.arrays;

public class 替换空格 {
    public String replaceSpace(StringBuffer str) {
        int P1 = str.length() - 1;
        // str的大小在变化 所以快开始就需要记录大小
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

    public String replaceSpace3(String s) {
        if (s == null || s.length() == 0) return s;

        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                num++;
            }
        }
        char[] chars = new char[s.length() + num];

        for (int i = 0, idx = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                chars[idx++] = '%';
                chars[idx++] = '2';
                chars[idx++] = '0';
            } else {
                chars[idx++] = s.charAt(i);
            }
        }

        return String.valueOf(chars);
    }

    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) return s;

        StringBuffer sb = new StringBuffer();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
    public String replaceSpace2(String str) {
        return str.replace(" ","%20");
    }
}
