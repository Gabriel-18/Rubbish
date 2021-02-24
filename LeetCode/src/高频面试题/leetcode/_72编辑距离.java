package 高频面试题.leetcode;

/**
 * 动态规划
 *
 * 定义 dp[i][j]
 * 21. dp[i][j] 代表 word1 中前 i 个字符，变换到 word2 中前 j 个字符，最短需要操作的次数
 * 22. 需要考虑 word1 或 word2 一个字母都没有，即全增加/删除的情况，所以预留 dp[0][j] 和 dp[i][0]
 *
 * 状态转移
 * 31. 增，dp[i][j] = dp[i][j - 1] + 1
 * 32. 删，dp[i][j] = dp[i - 1][j] + 1
 * 33. 改，dp[i][j] = dp[i - 1][j - 1] + 1
 * 34. 按顺序计算，当计算 dp[i][j] 时，dp[i - 1][j] ， dp[i][j - 1] ， dp[i - 1][j - 1] 均已经确定了
 * 35. 配合增删改这三种操作，需要对应的 dp 把操作次数加一，取三种的最小
 * 36. 如果刚好这两个字母相同 word1[i - 1] = word2[j - 1] ，那么可以直接参考 dp[i - 1][j - 1] ，操作不用加一
 *
 */
public class _72编辑距离 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        // 插入操作
        for(int i = 1; i <= len1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }

        // 删除操作
        for(int i = 1;i <= len2; i++) {
            dp[0][i] = dp[0][i - 1] + 1;
        }

        for(int i = 1; i <= len1; i++) {
            for(int j = 1; j <= len2; j++) {
                // 删除操作：dp[i - 1][j]
                // 增加操作：dp[i][j - 1]
                // 替换操作：dp[i - 1][j - 1]
                dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
                // 如'abc','bac' ，最后一个位置相同，所以求'ab','ba'的结果就好了
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
            }
        }

        return dp[len1][len2];
    }
}
