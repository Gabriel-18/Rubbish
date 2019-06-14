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
            // 保证字典序并且比当前的大 一样长的时候考虑字典序 < 0 表示字典序小 a - c类似
            if (l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) {
                continue;
            }
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
