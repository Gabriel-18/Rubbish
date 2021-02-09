package 高频面试题.牛客;

public class 判断回文 {
    public boolean judge (String str) {
        // write code here
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
