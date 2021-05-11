package DynamicProgramming;

/**
 * 309.给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class MaxProfit_WithFreeze {

    /**
     * tip:由于此时交易的次数不受限制，因此此时的状态只有两个，一个是天数i，一个是是否持有股票 0和1，因此是二维的dp
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length<=1)
            return 0;
        int[] hold=new int[prices.length];
        int[] notHold=new int[prices.length];
        hold[0]=-prices[0];
        notHold[0]=0;
        hold[1]=Math.max(-prices[0],-prices[1]);
        notHold[1]=Math.max(notHold[0],hold[0]+prices[1]);
        for(int i=2;i<prices.length;i++){
            hold[i]=Math.max(hold[i-1],notHold[i-2]-prices[i]);
            notHold[i]=Math.max(notHold[i-1],hold[i-1]+prices[i]);
        }
        return notHold[prices.length-1];
    }
}
