package DynamicProgramming;

public class MaxProfit_NoCntLimitFreezePeriod {

    /**
     * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * 示例:
     * 输入: [1,2,3,0,2]
     * 输出: 3
     * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
     * tips:冷冻期限制买入但是不限制卖出！！！与无限制动态规划思路类似
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int[] maxNoHoldProfit = new int[prices.length]; //当天不持有股票的最大收益
        int[] maxHoldProfit = new int[prices.length]; //当天持有股票的最大收益
        maxNoHoldProfit[0] = 0;
        maxHoldProfit[0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            maxNoHoldProfit[i] = Math.max(maxHoldProfit[i - 1] + prices[i], maxNoHoldProfit[i - 1]);
            maxHoldProfit[i] = Math.max(i >= 2 ? maxNoHoldProfit[i - 2] - prices[i] : -prices[i], maxHoldProfit[i - 1]);
        }
        return maxNoHoldProfit[prices.length - 1];
    }
}
