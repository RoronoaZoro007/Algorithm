package DynamicProgramming;

import java.util.Stack;

public class MaximalRectangle {

    /**
     * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
     * 柱状图求最大矩形面积的解法
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        //表示以当前为开始左侧的1的最大数量
        int[][] leftMax = new int[row][col];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (i == 0) {
                    leftMax[j][i] = matrix[j][i] == '1' ? 1 : 0;
                } else {
                    leftMax[j][i] = matrix[j][i] == '1' ? leftMax[j][i - 1] + 1 : 0;
                }
            }
        }

        Stack<Integer> stack = new Stack<>();
        int[] upToDown = new int[row];
        int[] downToUp=new int[row];
        int result=0;
        //每列进行最大矩形面积的判定
        //就是当前列为底，左边的1的最大数量为柱的最大高度
        for (int i = 0; i < col; i++) {
            stack.clear();
            for (int j = 0; j < row; j++) {
                while (!stack.isEmpty() && leftMax[j][i] <= leftMax[stack.peek()][i]) {
                    stack.pop();
                }
                upToDown[j] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(j);
            }
            stack.clear();
            for (int j = row-1; j>=0; j--) {
                while (!stack.isEmpty() && leftMax[j][i] <= leftMax[stack.peek()][i]) {
                    stack.pop();
                }
                downToUp[j] = stack.isEmpty() ? row : stack.peek();
                stack.push(j);
                result=Math.max(result,(downToUp[j]-upToDown[j]-1)*leftMax[j][i]);
            }
        }
        return result;
    }
}
