package DynamicProgramming;

public class MaxProfitInStock {

    /**
     * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。
     * <p>
     * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     * <p>
     * 返回获得利润的最大值。
     * <p>
     * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
     * <p>
     * 示例 1:
     * <p>
     * 输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
     * 输出: 8
     * 解释: 能够达到的最大利润:
     * 在此处买入 prices[0] = 1
     * 在此处卖出 prices[3] = 8
     * 在此处买入 prices[4] = 4
     * 在此处卖出 prices[5] = 9
     * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
     *
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1)
            return 0;
        int[][] maxProfit = new int[prices.length][2];
        //0表示没有股票的最大利润 1表示有股票的最大利润
        maxProfit[0][0] = 0;
        maxProfit[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            //当前不持有股票的最大值=上一次不持有股票的最大值  上一次持有股票的最大值+在当前价格卖出的利润
            maxProfit[i][0] = Math.max(maxProfit[i - 1][0], maxProfit[i - 1][1] + prices[i] - fee);
            //当前持有股票的最大值=上一次不持有股票-当前价格的扣费  上一次持有股票的最大值
            maxProfit[i][1] = Math.max(maxProfit[i - 1][0] - prices[i], maxProfit[i - 1][1]);
        }
        return maxProfit[prices.length - 1][0];
    }
}
