package leetcode;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 *
 *time; O(N * N)
 *space; O(N * N)
 *难点在于边界上
 */
public class LongestPalidromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String res = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;

        for (int j = 0; j < s.length();j++) {
            for (int i = 0; i <= j; i++) {
                // j - i <= 2 中间只能有一个字符
                dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i) <= 2 || dp[i + 1][j - 1] );
                if (dp[i][j]) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }
    private int len = 0;
    private int begin = 0;

    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) return s;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            //奇回文数
            expand(chs, i, i);
            // 偶回文数
            expand(chs, i, i + 1);
        }
        return s.substring(begin, begin + len);

    }
    public void expand(char[] chs, int L, int R) {
        while (L >= 0 && R < chs.length && chs[L] == chs[R]) {
            L --;
            R ++;
        }
        //不符合要求时
        if (R - L - 1 > len) {
            len = R - L -1 ;
            begin = L + 1;
        }
    }
}
