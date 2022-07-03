package hot100;

public class _5最长回文子串 {

    public String longestPalindrome(String s) {
        int[][] dp = new int[s.length() + 1][s.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp.length; j++) {
                dp[i][j] = 0;
            }
        }

        int max = 0;
        int l = 0;
        int r = 0;
        int cur = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = 1;
                    } else if (dp[i + 1][j - 1] == 1) {
                        dp[i][j] = 1;
                    }
                }

                cur = j - i + 1;
                if (dp[i][j] == 1 && cur > max) {
                    max = cur;
                    l = i;
                    r = j;
                }

            }
        }
        // 左包右开
        return s.substring(l, r + 1);
    }
}
