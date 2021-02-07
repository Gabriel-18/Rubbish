package 高频面试题.leetcode;

public class _121买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int now = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (now > prices[i]) {
                now = prices[i];
            } else {
                max = Math.max(max, prices[i] - now);
            }
        }
        return max;
    }
}
