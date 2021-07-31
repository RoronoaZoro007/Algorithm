package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * 120 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同
 * 或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * 示例 1：
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 * 输入：triangle = [[-10]]
 * 输出：-10
 */
public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() <= 0) {
            return Integer.MIN_VALUE;
        }
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < triangle.size(); i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            if (i == 0) {
                temp.add(triangle.get(0).get(0));
            } else {
                int size = triangle.get(i).size();
                for (int j = 0; j < size; j++) {
                    if (j == 0) {
                        temp.add(dp.get(i - 1).get(j) + triangle.get(i).get(j));
                    } else if (j == size - 1) {
                        temp.add(dp.get(i - 1).get(size - 2) + triangle.get(i).get(j));
                    } else {
                        temp.add(Math.min(dp.get(i - 1).get(j), dp.get(i - 1).get(j - 1)) + triangle.get(i).get(j));
                    }
                }
            }
            dp.add(temp);
        }
        int minVal = Integer.MAX_VALUE;
        for (int num : dp.get(dp.size() - 1)) {
            minVal = Math.min(minVal, num);
        }
        return minVal;
    }
}
