package BackTrack;

public class LongestIncreasingPath {

    /**
     * 329 矩阵中的最长递增路径
     * 给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。
     * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。
     *
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        longestPath = new int[row][col];
        isVisited = new boolean[row][col];
        int result = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result = Math.max(result, getResult(matrix, i, j));
            }
        }
        return result;
    }

    int[][] direction = new int[][]{{-1, 1, 0, 0}, {0, 0, -1, 1}};
    //剪枝用的，如果之前已经计算过了，就不用再计算了
    int[][] longestPath;
    //在当前遍历中避免重复经过同一个重复节点
    boolean[][] isVisited;

    private int getResult(int[][] matrix, int posX, int posY) {
        if (longestPath[posX][posY] != 0)
            return longestPath[posX][posY];
        if (isVisited[posX][posY]) {
            return 0;
        }
        int maxVal = 0;
        isVisited[posX][posY] = true;
        for (int i = 0; i < 4; i++) {
            int newX = posX + direction[0][i];
            int newY = posY + direction[1][i];
            if (newX >= 0 && newX < matrix.length && newY >= 0 && newY < matrix[0].length
                    && matrix[newX][newY] > matrix[posX][posY]) {
                maxVal = Math.max(maxVal, getResult(matrix, newX, newY));
            }
        }
        isVisited[posX][posY] = false;
        longestPath[posX][posY] = 1 + maxVal;
        return longestPath[posX][posY];
    }

}
