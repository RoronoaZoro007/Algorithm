package Arrays;

import java.util.Arrays;

/**
 * 48、旋转图像
 * 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * matrix.length == n
 * matrix[i].length == n
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */
public class Rotate {

    public static void main(String[] args) {
        int[][] arr=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(arr);
    }

    public static void rotate(int[][] matrix) {
        if(matrix==null||matrix.length<=0||matrix[0].length<=0)
            return;
        int len=matrix.length;
        for (int i = 0; i < len/2; i++) {
            for (int j = 0; j < (len+1)/2; j++) {
                int temp=matrix[i][j];
                matrix[i][j]=matrix[len-1-j][i];
                matrix[len-1-j][i]=matrix[len-1-i][len-1-j];
                matrix[len-1-i][len-1-j]=matrix[j][len-1-i];
                matrix[j][len-1-i]=temp;
            }
        }
        for (int i = 0; i < len; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }
}
