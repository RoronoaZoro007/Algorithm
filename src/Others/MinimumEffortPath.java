package Others;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumEffortPath {

    public static void main(String[] args) {
        MinimumEffortPath minimumEffortPath = new MinimumEffortPath();
        int[][] abc = {{1, 2, 2}, {3, 8, 2}, {5, 3, 5}};
        System.out.println(minimumEffortPath.minimumEffortPath(abc));
    }

    /**
     * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。
     * 一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。
     * 你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
     * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
     * 请你返回从左上角走到右下角的最小 体力消耗值 。
     * 例如：1 ，2 ，2
     * 3 ，8 ，2
     * 5 ，3, ，5
     *
     * @param heights
     * @return
     */
    public int minimumEffortPath(int[][] heights) {
        int row = heights.length;
        if (row < 1)
            return 0;
        int col = heights[0].length;
        int[][] gap = {{1, -1, 0, 0}, {0, 0, 1, -1}};

        int[][] minVal = new int[row][col];
        for (int[] height : heights) {
            Arrays.fill(height, Integer.MAX_VALUE);
        }
        Boolean[][] isInS = new Boolean[row][col];
        for (Boolean[] temp : isInS) {
            Arrays.fill(temp, false);
        }
        PriorityQueue<Pair<Integer, Integer>> queue =
                new PriorityQueue<>((t1, t2) -> minVal[t2.getKey()][t2.getValue()] - minVal[t1.getKey()][t1.getValue()]);
        queue.add(new Pair<>(0, 0));
        minVal[0][0] = 0;
        isInS[0][0] = true;
        while (queue.size() < row * col) {
            Pair<Integer, Integer> pair = queue.peek();
            int x = pair.getKey();
            int y = pair.getValue();
            for (int i = 0; i < 4; i++) {
                int newX = x + gap[0][i];
                int newY = y + gap[1][i];
                if (newX >= 0 && newX < row && newY >= 0 && newY < col) {
                    System.out.println(newX + "  " + newY);
                    minVal[newX][newY] = Math.min(minVal[newX][newY], minVal[x][y] + Math.abs(heights[x][y] - heights[newX][newY]));
                    if (!isInS[newX][newY]) {
                        queue.add(new Pair<>(newX, newY));
                        isInS[newX][newY] = true;
                    }
                }
            }
        }
        return minVal[row - 1][col - 1];
    }
}
