package leetcode;

public class IsSubsequence {
    /**
     * https://leetcode.com/problems/is-subsequence/description/
     *392. Is Subsequence
     * 审题
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }
}
