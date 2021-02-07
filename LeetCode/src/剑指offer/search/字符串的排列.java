package 剑指offer.search;

import java.util.ArrayList;
import java.util.Arrays;

public class 字符串的排列 {
    private ArrayList<String> ret = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        // 边界
        if (str.length() == 0) {
            return ret;
        }
        // 转数组
        char[] chars = str.toCharArray();
        // 保证重复元素相邻
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuffer());
        return ret;
    }

    private void backtracking(char[] chars, boolean[] hasUsed, StringBuffer s) {
        if (s.length() == chars.length) {
            ret.add(s.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (hasUsed[i]) {
                continue;
            }

            // 没有被用过 且不重复
            // 就能保证不重复
            if (i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) {
                System.out.println(hasUsed[i-1]);
                continue;
            }
            // A1 B2  B3
            // 1 3 2必然重复
            hasUsed[i] = true;
            s.append(chars[i]);
            backtracking(chars, hasUsed, s);
            // 恢复现场
            s.deleteCharAt(s.length() - 1);
            hasUsed[i] = false;
        }
    }

    public String[] permutation(String str) {
        // 边界
        if (str.length() == 0) {
            return ret.toArray(new String[0]);
        }
        // 转数组
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars, new boolean[chars.length], new StringBuffer());
        return ret.toArray(new String[0]);
    }
}
