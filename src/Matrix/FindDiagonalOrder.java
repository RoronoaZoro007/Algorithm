package Matrix;

import java.util.Arrays;

public class FindDiagonalOrder {

    /**
     * 498.对角线遍历
     * 给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。
     * 示例:
     * 输入:
     * [
     * [ 1, 2, 3 ],
     * [ 4, 5, 6 ],
     * [ 7, 8, 9 ]
     * ]
     * 输出:  [1,2,4,7,5,3,6,8,9]
     */

    /**
     * 只有两个前进方向，↗️和↙️
     * tip：超出边界情况，先会到变化前的位置向↗️方向的优先往右，随后才是往下，然后变化前进的方向为↙️；
     * 向↙️方向的优先往下，下不行了再向右，然后变化前进方向为↗️；
     */
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length <= 0 || mat[0].length <= 0)
            return new int[0];
        //
        int[][] direction = new int[][]{{-1, 1}, {1, -1}};
        int posX = 0;
        int posY = 0;
        //0表示↗️，1表示↙️
        int direct = 0;
        int cnt = 0;
        int row = mat.length;
        int col = mat[0].length;
        int size = row * col;
        int[] out = new int[size];
        while (cnt < size) {
            out[cnt] = mat[posX][posY];
            posX += direction[direct][0];
            posY += direction[direct][1];
            if (!isValid(posX, posY, row, col)) {
                posX -= direction[direct][0];
                posY -= direction[direct][1];
                if (direct == 0) {
                    if (posY < col - 1) {
                        //优先往右
                        posY++;
                    } else {
                        //右不行了再往下
                        posX++;
                    }
                    direct = 1;
                } else {
                    if (posX < row - 1) {
                        //优先往下
                        posX++;
                    } else {
                        //下不行了再往右
                        posY++;
                    }
                    direct = 0;
                }
            }
            cnt++;
        }
        return out;
    }

    private boolean isValid(int posX, int posY, int row, int col) {
        return posX >= 0 && posX < row && posY >= 0 && posY < col;
    }

    public static void main(String[] args) {
        FindDiagonalOrder findDiagonalOrder = new FindDiagonalOrder();
        int[] diagonalOrder = findDiagonalOrder.findDiagonalOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        System.out.println(Arrays.toString(diagonalOrder));
    }
}
