package leetcode;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 *121. Best Time to Buy and Sell Stock
 */
public class BestTimetoBuyandSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        int min = prices[0];
        int profit = 0;

        for (int price : prices) {
            min = Math.min(min, price);
            profit = Math.max(profit, price - min);
        }
        return profit;
    }

    /**
     * 选出最小价格
     * 出售比较收益
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
