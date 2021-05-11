package DynamicProgramming.PackageQuestion;

/**
 * 746.使用最小花费爬楼梯
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出：6
 * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        if(cost==null||cost.length<=1)
            return 0;
        int len=cost.length;
        //以当前阶梯作为最后一个阶梯的最小花费
        int[] minCost=new int[len+1];
        minCost[0]=0;
        minCost[1]=cost[0];
        for(int i=2;i<=len;i++){
            minCost[i]=Math.min(minCost[i-2],minCost[i-1])+cost[i-1];
        }
        return Math.min(minCost[len],minCost[len-1]);
    }
}
