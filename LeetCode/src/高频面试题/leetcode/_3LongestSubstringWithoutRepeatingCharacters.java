package 高频面试题.leetcode;

import java.util.HashMap;

public class _3LongestSubstringWithoutRepeatingCharacters {
    /**

     Given a string, find the length of the longest substring without repeating characters.

     Example 1:

     Input: "abcabcbb"
     Output: 3
     Explanation: The answer is "abc", with the length of 3.
     Example 2:

     Input: "bbbbb"
     Output: 1
     Explanation: The answer is "b", with the length of 1.
     Example 3:

     Input: "pwwkew"
     Output: 3
     Explanation: The answer is "wke", with the length of 3.
     Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
      time : O(n)
      space : O(n)
     * @param s
     * @return
     */
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
