package DynamicProgramming;

import java.math.BigDecimal;

public class MaxProfit_2CntLimit {

    /**
     * 123.给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 示例 1:
     * 输入: [3,3,5,0,0,3,1,4]
     * 输出: 6
     * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     *      随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
     */

    public int maxProfit(int[] prices) {
        if (prices.length <= 1)
            return 0;
        int firstBuy = -prices[0]; //当前这次为第一次购买的最大利润
        int firstSale = 0; //当前这次为第一次出售的最大利润
        int secondBuy = -prices[0]; //当前这次为第二次购买的最大利润
        int secondSale = 0; //当前这次为第二次出售的最大利润
        for (int i = 1; i < prices.length; i++) {
            firstBuy = Math.max(-prices[i - 1], firstBuy);
            firstSale = Math.max(firstBuy + prices[i], firstSale);
            secondBuy = Math.max(firstSale - prices[i], secondBuy);
            secondSale = Math.max(secondBuy + prices[i], secondSale);
        }
        return secondSale;
    }

    public static void main(String[] args) {
        BigDecimal val = new BigDecimal(88);
        System.out.println(val.setScale(2, BigDecimal.ROUND_HALF_UP));
    }
}
