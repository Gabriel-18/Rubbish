package other;
//使用贪心策略，假设第 i 轮进行卖出操作，
// 买入操作价格应该在 i 之前并且价格最低。
public class 股票的最大利润 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int soFarMin = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            soFarMin = Math.min(soFarMin, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - soFarMin);
        }
        return maxProfit;
    }

}
