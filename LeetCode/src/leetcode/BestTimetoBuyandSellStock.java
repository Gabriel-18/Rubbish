package leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *121. Best Time to Buy and Sell Stock
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        // 边界处理
        if (prices == null || prices.length < 2) {
            return 0;
        }
        // 假设第一次为最低价
        int min = prices[0];
        // 此时收益为0
        int profit = 0;

        for (int price : prices) {
            // 当前价格与之前的最小价格比较
            min = Math.min(min, price);
            // 计算当前收益 并 与之前的最大收益比较
            profit = Math.max(profit, price - min);
        }
        // 返回收益
        return profit;
    }

    /**
     * 选出最小价格
     * 出售比较收益
     * 感觉思路差不多
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int soFarMin = prices[0];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (soFarMin > prices[i]) {
                soFarMin = prices[i];
            } else {
                max = Math.max(max, prices[i] - soFarMin);
            }
        }
        return max;
    }
}
