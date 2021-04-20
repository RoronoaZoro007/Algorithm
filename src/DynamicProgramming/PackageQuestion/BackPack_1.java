package DynamicProgramming.PackageQuestion;

public class BackPack_1 {

    /**
     * 在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]
     *
     * @param m
     * @param A
     * @return
     */
    public int backPack(int m, int[] A) {
        // write your code here
        int[][] dp = new int[A.length + 1][m + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - A[i - 1]] + A[i - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[A.length][m];
    }

    /**
     * 有 n 个物品和一个大小为 m 的背包. 给定数组 A 表示每个物品的大小和数组 V 表示每个物品的价值.
     * 问最多能装入背包的总价值是多大?
     *
     * @param m
     * @param A
     * @param V
     * @return
     */
    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int[][] dp = new int[A.length + 1][m + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= m; j++) {
                if (A[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(V[i - 1] + dp[i - 1][j - A[i - 1]], dp[i - 1][j]);
                }
            }
        }
        return dp[A.length][m];
    }


    /**
     * 给定 n 种物品, 每种物品都有无限个. 第 i 个物品的体积为 A[i], 价值为 V[i].
     * 再给定一个容量为 m 的背包. 问可以装入背包的最大价值是多少?
     * @param A
     * @param V
     * @param m
     * @return
     */
    public int backPackIII(int[] A, int[] V, int m) {
        // write your code here

    }
}
