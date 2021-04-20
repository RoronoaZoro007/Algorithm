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
     * tip:由于此时物品是无限的，因此变量就只有重量这一个，因此dp数组是一维的
     *
     * @param A
     * @param V
     * @param m
     * @return
     */
    public int backPackIII(int[] A, int[] V, int m) {
        // write your code here
        int[] dp = new int[m + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = A[i - 1]; j <= m; j++) {
                if (j >= A[i - 1]) {
                    dp[j] = Math.max(dp[j - A[i - 1]] + V[i - 1], Math.max(dp[j], dp[j - 1]));
                }
            }
        }
        return dp[m];
    }

    /**
     * 给出 n 个物品, 以及一个数组, nums[i]代表第i个物品的大小, 保证大小均为正数并且没有重复,
     * 正整数 target 表示背包的大小, 找到能填满背包的方案数。
     * 每一个物品可以使用无数次
     * tip：无限次数的，只有背包容量会变，只有一个状态会变，因此是一维的
     *
     * @param nums
     * @param target
     * @return
     */
    public int backPackIV(int[] nums, int target) {
        // write your code here
        int[] dp = new int[target + 1];
        dp[0] = 1; //代表当前背包容量为0还是存在一种方案的
        for (int i = 1; i <= nums.length; i++) {
            for (int j = nums[i - 1]; j <= target; j++) {
                //减去该物品的重量为0，说明dp[j-nums[i-1]]是存在方案的
                dp[j] += dp[j - nums[i - 1]];
            }
        }
        return dp[target];
    }

    /**
     * 给出 n 个物品, 以及一个数组, nums[i] 代表第i个物品的大小, 保证大小均为正数,
     * 正整数 target 表示背包的大小, 找到能填满背包的方案数。
     * 每一个物品只能使用一次
     * tip：可用物品和背包容量两个状态变化，是二维dp数组
     *
     * @param nums
     * @param target
     * @return
     */
    public int backPackV(int[] nums, int target) {
        // write your code here
        //表示使用前i个物品，target为j的方案个数
        int[][] dp = new int[nums.length + 1][target + 1];
        //初始化base,target为0都有一种方案来实现
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - nums[i - 1] < 0) {
                    //如果当前放不下第i个物品，那么就取不用i的方案数
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //当前不用i的方案数+用i的方案数
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][target];
    }

    /**
     * 你总共有n 万元，希望申请国外的大学，要申请的话需要交一定的申请费用，给出每个大学的申请费用以及你得到这个大学offer的成功概率，
     * 大学的数量是 m。如果经济条件允许，你可以申请多所大学。找到获得至少一份工作的最高可能性。
     * 输入:
     * n = 10
     * prices = [4,4,5]
     * probability = [0.1,0.2,0.3]
     * 输出:  0.440
     * <p>
     * 解释：
     * 选择第2和第3个学校。
     * <p>
     * 输入:
     * n = 10
     * prices = [4,5,6]
     * probability = [0.1,0.2,0.3]
     * 输出:  0.370
     * <p>
     * 解释:
     * 选择第1和第3个学校。
     * <p>
     * tip:钱和可选择的学校是变化的
     *
     * @param n
     * @param prices
     * @param probability
     * @return
     */
    public double backpackIX(int n, int[] prices, double[] probability) {
        // write your code here
        // 表示可选学校为前i所时，拥有的钱为j，此时最小申请不上的概率
        double[][] dp = new double[prices.length + 1][n + 1];
        for (int i = 1; i <= prices.length; i++) {
            for (int j = 1; j <= n; j++) {
                //钱不够申请第i个学校，概率等于可选学校为前i-1所的概率
                dp[i][j] = dp[i - 1][j];
                //最小概率为选择第i所学校申请不上最小概率，和不选择第i所学校申请不上的最小概率的min
                if (j - prices[i - 1] >= 0)
                    dp[i][j] = Math.min((1 - probability[i - 1]) * dp[i - 1][j - prices[i - 1]], dp[i - 1][j]);
            }
        }
        return dp[prices.length][n];
    }

    public static void main(String[] args) {
        BackPack_1 backPack_1 = new BackPack_1();
//        System.out.println(backPack_1.backPackIII(new int[]{2, 3, 5, 7}, new int[]{1, 5, 2, 4}, 10));
//        System.out.println(backPack_1.backPackIV(new int[]{2, 3, 4, 5}, 7));
//        System.out.println(backPack_1.backPackV(new int[]{1, 2, 3, 3, 7}, 7));
        System.out.println(backPack_1.backpackIX(10, new int[]{4, 4, 5}, new double[]{0.1, 0.2, 0.3}));
    }
}
