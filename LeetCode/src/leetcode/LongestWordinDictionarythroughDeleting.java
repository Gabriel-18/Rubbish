package leetcode;

import java.util.List;

public class LongestWordinDictionarythroughDeleting {
    /***
     * 524. Longest Word in Dictionary through Deleting
     * https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/description/
     * @param s
     * @param d
     * @return
     */
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String target : d) {

            int l1 = longestWord.length(), l2 = target.length();
            //第一个条件是 find the longest string in the dictionary
            // 保证字典序并且比当前的大
            // 一样长的时候考虑字典序 < 0
            // 表示字典序小 a - c类似
            // 针对第二个条件
            //  If there are more than one possible results,
            //  return the longest word with the smallest lexicographical order.
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }

            // 符合字串即替代
            //核心代码
            if (isSubstr(s, target)) {
                longestWord = target;
            }
        }
        return longestWord;
    }

    private boolean isSubstr(String s, String target) {
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()) {
            if (s.charAt(i) == target.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == target.length();
    }
}
