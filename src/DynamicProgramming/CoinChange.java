package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {

    /**
     * 322.给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
     * 如果没有任何一种硬币组合能组成总金额，返回 -1。
     * 你可以认为每种硬币的数量是无限的。
     *
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

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2}, 3));
    }
}
