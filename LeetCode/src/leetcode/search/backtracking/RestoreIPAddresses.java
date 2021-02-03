package leetcode.search.backtracking;

import java.util.ArrayList;
import java.util.List;
//["0.1.0.010","0.1.00.10","0.1.001.0","0.10.0.10",
// "0.10.01.0","0.100.1.0","01.0.0.10","01.0.01.0","01.00.1.0","010.0.1.0"]
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> addresses = new ArrayList<>();
        StringBuilder tempAddress = new StringBuilder();
        doRestore(0, tempAddress, addresses, s);
        return addresses;
    }

    private void doRestore(int k, StringBuilder tempAddress, List<String> addresses, String s) {
        // 结束
        // 4 —> 1
        if (k == 4 || s.length() == 0) {
            if (k == 4 && s.length() == 0) {
                addresses.add(tempAddress.toString());
            }
            return;
        }

        // i的语义
        // 当前字符串的偏移量
        for (int i = 0; i < s.length() && i <= 2; i++) {
             // 大于 1 位的时候，不能以 0 开头
            // 只有一位的时候 可以以0开头
            if (i != 0 && s.charAt(0) == '0') {
                break;
            }
            String part = s.substring(0, i + 1);

            // 小于等于255
            if (Integer.valueOf(part) <= 255) {
                // 不是第一段
                // 234段
                // 需要在数字部分前面加上.
                if (tempAddress.length() != 0) {
                    part = "." + part;
                }
                // 加入part
                tempAddress.append(part);
                doRestore(k + 1, tempAddress, addresses, s.substring(i + 1));
                // 删除part 只能从长度上面做手脚
                tempAddress.delete(tempAddress.length() - part.length(), tempAddress.length());
            }
        }
    }
}
