package Arrays;

import java.util.ArrayList;
import java.util.List;


/**
 * 54.螺旋矩阵 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 */
public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null)
            return result;
        int row = matrix.length;
        int col = matrix[0].length;
        if (row <= 0 || col <= 0)
            return result;
        //用来判断当前位置是否被访问过
        boolean[][] isVisited = new boolean[row][col];
        int posx = 0;
        int posy = 0;
        while (posx >= 0 && posx < row && posy >= 0 && posy < col && !isVisited[posx][posy]) {
            while (posy < col && !isVisited[posx][posy]) {
                result.add(matrix[posx][posy]);
                isVisited[posx][posy] = true;
                posy++;
            }
            //超出界限位置，需要更新方向，将起始位置配置在下一个方向的起始位置
            posy--;
            posx++;
            while (posx < row && !isVisited[posx][posy]) {
                result.add(matrix[posx][posy]);
                isVisited[posx][posy] = true;
                posx++;
            }
            posx--;
            posy--;
            while (posy >= 0 && !isVisited[posx][posy]) {
                result.add(matrix[posx][posy]);
                isVisited[posx][posy] = true;
                posy--;
            }
            posy++;
            posx--;
            while (posx >= 0 && !isVisited[posx][posy]) {
                result.add(matrix[posx][posy]);
                isVisited[posx][posy] = true;
                posx--;
            }
            posx++;
            posy++;
        }
        return result;
    }
}
