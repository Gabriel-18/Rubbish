package 高频面试题.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _93复原IP地址 {
    List<String> ret = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {

        StringBuffer temp = new StringBuffer();
        backtracking(0, temp,s);
        return ret;
    }

    private void backtracking(int k, StringBuffer temp, String s) {
        if (k == 4 || s.length() == 0) {
            if (k == 4 && s.length() == 0) {
                ret.add(temp.toString());
            }
            return;
        } else {
            // 划分字符串
            // 剪枝
            for (int i = 0; i < s.length() && i <= 2; i++) {
                // 解决前导0
                if (i != 0 && s.charAt(0) == '0') {
                    break;
                }
                // 截取部分
                String part = s.substring(0, i + 1);
                // 校验
                if (Integer.valueOf(part) <= 255) {
                    if (temp.length() != 0) {
                        part = "." + part;
                    }
                    temp.append(part);
                    backtracking(k+1, temp, s.substring(i+1));
                    temp.delete(temp.length() - part.length(), temp.length());
                }
            }
        }
    }
}
