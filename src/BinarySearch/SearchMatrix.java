package BinarySearch;

/**
 * 74 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 */
public class SearchMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0)
            return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int maxSize = row * col - 1;
        int start = 0;
        int end = maxSize;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int tempRow = mid / col;
            int tempCol = mid % col;
            if (matrix[tempRow][tempCol] == target) {
                return true;
            } else if (matrix[tempRow][tempCol] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return matrix[start / col][start % col] == target;
    }
}
