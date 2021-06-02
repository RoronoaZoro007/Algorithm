package DynamicProgramming;

/**
 * 221、最大正方形
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * 输入：matrix = [
 * ["1","0","1","0","0"],
 * ["1","0","1","1","1"],
 * ["1","1","1","1","1"],
 * ["1","0","0","1","0"]]
 * 输出：4
 *
 * 输入：matrix = [
 * ["0","1"],
 * ["1","0"]]
 * 输出：1
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length<=0||matrix[0].length<=0)
            return 0;
        int row=matrix.length;
        int col=matrix[0].length;
        //以此位置为右下角的正方形的最大的边长
        int[][] dp=new int[row][col];
        int maxLen=0;
        for (int i = 0; i < col; i++) {
            dp[0][i]=matrix[0][i]=='1'?1:0;
            maxLen=Math.max(maxLen,dp[0][i]);
        }
        for (int i = 0; i < row; i++) {
            dp[i][0]=matrix[i][0]=='1'?1:0;
            maxLen=Math.max(maxLen,dp[i][0]);
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(matrix[i][j]=='1'){
                    //例如：如果dp[i-1][j-1]=2，如果要囊括这个位置的正方形，
                    //那么dp[i-1][j]向左这么长都要是1和dp[i][j-1]向上这么长都是1
                    //这么长的1加上dp[i-1][j-1]的正方形的1，就又可以构成一个正方形
                    //递推公式就出来了
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                    maxLen=Math.max(maxLen,dp[i][j]);
                }
            }
        }
        return maxLen*maxLen;
    }
}
