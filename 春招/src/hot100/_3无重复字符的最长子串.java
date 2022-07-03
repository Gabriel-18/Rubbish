package hot100;

import java.util.HashMap;

public class _3无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        // 记录字符上次出现的位置
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // 更新策略
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max, i - left + 1);
        }
        return max;

    }
}
