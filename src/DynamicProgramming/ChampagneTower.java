package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 799 香槟塔
 * 我们把玻璃杯摆成金字塔的形状，其中第一层有1个玻璃杯，第二层有2个，依次类推到第100层，每个玻璃杯(250ml)将盛有香槟。
 * 从顶层的第一个玻璃杯开始倾倒一些香槟，当顶层的杯子满了，任何溢出的香槟都会立刻等流量的流向左右两侧的玻璃杯。当左右两边的杯子也满了，
 * 就会等流量的流向它们左右两边的杯子，依次类推。（当最底层的玻璃杯满了，香槟会流到地板上）
 * 例如，在倾倒一杯香槟后，最顶层的玻璃杯满了。倾倒了两杯香槟后，第二层的两个玻璃杯各自盛放一半的香槟。在倒三杯香槟后，第二层的香槟满了 -
 * 此时总共有三个满的玻璃杯。在倒第四杯后，第三层中间的玻璃杯盛放了一半的香槟，他两边的玻璃杯各自盛放了四分之一的香槟，如下图所示。
 * 示例 1:
 * 输入: poured(倾倒香槟总杯数) = 1, query_glass(杯子的位置数) = 1, query_row(行数) = 1
 * 输出: 0.0
 * 解释: 我们在顶层（下标是（0，0））倒了一杯香槟后，没有溢出，因此所有在顶层以下的玻璃杯都是空的。
 * 示例 2:
 * 输入: poured(倾倒香槟总杯数) = 2, query_glass(杯子的位置数) = 1, query_row(行数) = 1
 * 输出: 0.5
 * 解释: 我们在顶层（下标是（0，0）倒了两杯香槟后，有一杯量的香槟将从顶层溢出，位于（1，0）的玻璃杯和（1，1）的玻璃杯平分了这一杯香槟，所以每个玻璃杯有一半的香槟。
 * poured 的范围[0, 10 ^ 9]。
 * query_glass 和query_row 的范围 [0, 99]。
 */
public class ChampagneTower {

    public double champagneTower(int poured, int query_row, int query_glass) {
        //用来存储每层中每个位置流过的香槟的数量
        //tip：例如最顶层流过10杯的话，那么有（10-1）杯会流到下面的两个杯子中，依此类推
        //tip：最左边的杯子和最右边的杯子最多只会有一个上一层杯子中溢出的香槟流过，中间的杯子最多会有上一层的两个杯子溢出的香槟流过
        List<double[]> all = new ArrayList<>();
        double[] temp = new double[]{poured};
        all.add(temp);
        for (int i = 1; i <= query_row; i++) {
            double[] arr = new double[i + 1];
            double[] preLevel = all.get(i - 1);
            arr[0] = preLevel[0] > 1 ? (preLevel[0] - 1) / 2 : 0;
            arr[i] = preLevel[preLevel.length - 1] > 1 ? (preLevel[preLevel.length - 1] - 1) / 2 : 0;
            for (int j = 1; j < i; j++) {
                double left = preLevel[j - 1] > 1 ? (preLevel[j - 1] - 1) / 2 : 0;
                double right = preLevel[j] > 1 ? (preLevel[j] - 1) / 2 : 0;
                arr[j] = left + right;
            }
            all.add(arr);
        }
        double result = all.get(query_row)[query_glass];
        return result >= 1 ? 1 : result;
    }

    public static void main(String[] args) {
        ChampagneTower champagneTower = new ChampagneTower();
        System.out.println(champagneTower.champagneTower(4, 2, 1));
    }
}
