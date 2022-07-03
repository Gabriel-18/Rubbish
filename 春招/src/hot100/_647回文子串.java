package hot100;

public class _647回文子串 {

    public int countSubstrings(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                dp[i][j] = 0;
            }
        }

        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i >= 1) {
                        count++;
                        dp[i][j] = 1;
                    } else if (dp[i+1][j-1] == 1) {
                        count++;
                        dp[i][j] = 1;
                    }
                }
            }
        }
        return count;
    }
}
