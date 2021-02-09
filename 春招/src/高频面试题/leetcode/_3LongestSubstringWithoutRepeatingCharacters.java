package 高频面试题.leetcode;

import java.util.HashMap;

public class _3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                // update the index of new character
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            // put
            map.put(s.charAt(i), i);
            // update res if res < i - j + 1
            res = Math.max(res, i - j + 1);
        }
        return res;
    }


}
