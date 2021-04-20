package BackTrack;

public class CoinChange_2 {

    /**
     * 518.给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数。假设每一种面额的硬币有无限个。
     *
     * @param amount
     * @param coins
     * @return
     */
    public static int change(int amount, int[] coins) {
        int[] changeCnt = new int[amount + 1];
        changeCnt[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i < amount + 1; i++) {
                changeCnt[i] += changeCnt[i - coin];
            }
        }
        return changeCnt[amount];
    }

    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1, 2, 5}));
    }
}
