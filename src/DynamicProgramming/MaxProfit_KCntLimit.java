package DynamicProgramming;

import java.util.Arrays;

public class MaxProfit_KCntLimit {

    /**
     * 188.给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。
     * <p>
     * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
     * <p>
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 示例 1：
     * 输入：k = 2, prices = [2,4,1]
     * 输出：2
     * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
     * <p>
     * 示例 2：
     * 输入：k = 2, prices = [3,2,6,5,0,3]
     * 输出：7
     * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
     * tip:
     * 无论题目中是否允许「在同一天买入并且卖出」这一操作，最终的答案都不会受到影响，这是因为这一操作带来的收益为零。
     */

    public static void main(String[] args) {
        System.out.println(maxProfit(2, new int[]{3,2,6,5,0,3}));
    }

    public static int maxProfit(int k, int[] prices) {
        if (k <= 0 || prices.length <= 1)
            return 0;
        int[][] maxProfit = new int[k + 1][2]; //分别表示第k次购买和第k次出售的最大利润
        for (int i = 0; i <= k; i++) {
            maxProfit[i][0] = -prices[0];
            maxProfit[i][1] = 0;
        }
        for (int i = 0; i < prices.length; i++) {
            maxProfit[1][0] = Math.max(-prices[i], maxProfit[1][0]); //第一次购买
            maxProfit[1][1] = Math.max(maxProfit[1][0] + prices[i], maxProfit[1][1]);
            for (int j = 2; j <= k; j++) {
                maxProfit[j][0] = Math.max(maxProfit[j - 1][1] - prices[i], maxProfit[j][0]); //第j次购买的最大利润
                maxProfit[j][1] = Math.max(maxProfit[j][0] + prices[i], maxProfit[j][1]);
            }
        }
        return maxProfit[k][1];
    }

    /**
     * tip:可以看出实际的状态有3个，一个是第i天，完成了k笔交易，处于的状态是持有股票，还是不持有股票
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit_1(int k, int[] prices) {
        if(prices==null||prices.length<=1||k<=0)
            return 0;
        //表示交易完成了k次（就是卖出k次了），且持有股票的最大值
        int[][] hold=new int[prices.length][k+1];
        //表示交易完成了k次，且持有股票的最大值
        int[][] notHold=new int[prices.length][k+1];
        hold[0][0]=-prices[0];
        for(int i=1;i<=k;i++){
            //取不到的值要设置一个非法的数值，最小值！！！
            hold[0][i]=Integer.MIN_VALUE/3;
            notHold[0][i]=Integer.MIN_VALUE/3;
        }
        for(int i=1;i<prices.length;i++){
            //要更新完成次数为0的数值
            hold[i][0]=Math.max(hold[i-1][0],-prices[i]);
            for(int j=1;j<=k;j++){
                hold[i][j]=Math.max(hold[i-1][j],notHold[i-1][j]-prices[i]);
                notHold[i][j]=Math.max(notHold[i-1][j],hold[i-1][j-1]+prices[i]);
            }
        }
        return Arrays.stream(notHold[prices.length-1]).max().getAsInt();
    }
}
