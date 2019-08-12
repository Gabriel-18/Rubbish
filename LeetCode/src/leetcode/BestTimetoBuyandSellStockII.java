package leetcode;

public class BestTimetoBuyandSellStockII {
    /**
     * 122. Best Time to Buy and Sell Stock II
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
     * 拿前后两天做差,有的赚就交易
     * 有收益就做？
     * 对于 [a, b, c, d]，如果有 a <= b <= c <= d ，那么最大收益为 d - a。
     * 而 d - a = (d - c) + (c - b) + (b - a) ，
     * 因此当访问到一个 prices [i] 且 prices [i] - prices [i-1] > 0，
     * 那么就把 prices [i] - prices [i-1] 添加到收益中
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            // 可以赚钱就做 梭哈
            if (prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}
