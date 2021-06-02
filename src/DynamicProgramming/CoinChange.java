package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {

    /**
     * 322.给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
     * 如果没有任何一种硬币组合能组成总金额，返回 -1。
     * 你可以认为每种硬币的数量是无限的。
     * 输入：coins = [1, 2, 5], amount = 11
     * 输出：3
     * 解释：11 = 5 + 5 + 1
     * @param coins
     * @param amount
     * @return
     */
    public static int coinChange(int[] coins, int amount) {
        if (coins.length <= 0 || amount < 0)
            return -1;
        int[] minCnt = new int[amount + 1];
        Arrays.fill(minCnt, amount + 1);
        minCnt[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] < 0)
                    continue;
                minCnt[i] = Math.min(minCnt[i], minCnt[i - coins[j]] + 1);
            }
        }
        return minCnt[amount] == amount + 1 ? -1 : minCnt[amount];
    }


    public int coinChange_1(int[] coins,int amount){
        if (coins==null||coins.length <= 0 || amount < 0)
            return -1;
        int[] minCnt=new int[amount+1];
        Arrays.fill(minCnt,amount+1);
        minCnt[0]=0;
        for(int coin:coins){
            for (int i = 1; i <=amount ; i++) {
                if(i<coin)
                    continue;
                minCnt[i]=Math.min(minCnt[i],minCnt[i-coin]+1);
            }
        }
        return minCnt[amount]==amount+1?-1:minCnt[amount];
    }

    //518.兑换2
    // 给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
    //输入: amount = 5, coins = [1, 2, 5]
    //输出: 4
    //解释: 有四种方式可以凑成总金额:
    //5=5
    //5=2+2+1
    //5=2+1+1+1
    //5=1+1+1+1+1
    public static int change(int amount, int[] coins) {
        if (coins==null||coins.length <= 0 || amount < 0)
            return 0;
        int[] maxCnt=new int[amount+1];
        maxCnt[0]=1;
        //外层物品是求组合数
        //外层背包是求排列数
        for (int coin:coins){
            for (int i = coin; i <=amount; i++) {
                maxCnt[i]+=maxCnt[i-coin];
            }
        }
        return maxCnt[amount];
    }

    public static void main(String[] args) {
        System.out.println(change(3,new int[]{2}));
    }

}
