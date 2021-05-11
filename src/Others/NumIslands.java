package Others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 200.岛屿数量 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * 示例 1：
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 */
public class NumIslands {

    public static void main_1(String[] args) {
        NumIslands numIslands = new NumIslands();
        char[][] chars = new char[3][5];
        chars[0] = new char[]{'1', '0', '1', '1', '1'};
        chars[1] = new char[]{'1', '0', '1', '0', '1'};
        chars[2] = new char[]{'1', '1', '1', '0', '1'};
        System.out.println(numIslands.numIslands(chars));
    }

    public int numIslands(char[][] grid) {
        if (grid == null)
            return 0;
        int row = grid.length;
        int col = grid[0].length;
        int landCnt = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    landCnt++;
                    dfs(i, j, grid);
                }
            }
        }
        return landCnt;
    }

    private void dfs(int r, int c, char[][] grid) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length)
            return;
        if (grid[r][c] == '1') {
            grid[r][c] = '0';
            dfs(r - 1, c, grid);
            dfs(r, c - 1, grid);
            dfs(r + 1, c, grid);
            dfs(r, c + 1, grid);
        }
    }


    /**
     * 描述
     * 给定 n, m, 分别代表一个二维矩阵的行数和列数, 并给定一个大小为 k 的二元数组A. 初始二维矩阵全0. 二元数组A内的k个元素代表k次操作, 设第i个元素为 (A[i].x, A[i].y), 表示把二维矩阵中下标为A[i].x行A[i].y列的元素由海洋变为岛屿. 问在每次操作之后, 二维矩阵中岛屿的数量. 你需要返回一个大小为k的数组.
     * 设定0表示海洋, 1代表岛屿, 并且上下左右相邻的1为同一个岛屿.
     * 样例
     * 样例 1:
     * 输入: n = 4, m = 5, A = [[1,1],[0,1],[3,3],[3,4]]
     * 输出: [1,1,2,2]
     * 解释:
     * 0.  00000
     * 00000
     * 00000
     * 00000
     * 1.  00000
     * 01000
     * 00000
     * 00000
     * 2.  01000
     * 01000
     * 00000
     * 00000
     * 3.  01000
     * 01000
     * 00000
     * 00010
     * 4.  01000
     * 01000
     * 00000
     * 00011
     *
     * @param n
     * @param m
     * @param operators
     * @return
     */
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if (n <= 0 || m <= 0 || operators == null || operators.length <= 0)
            return result;
        int[][] land = new int[n][m];
        int landCnt = 0;
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int[] roots = new int[n * m];
        //代表每个位置的根岛屿是哪个
        Arrays.fill(roots, -1);
        for (Point point : operators) {
            int id = point.x * m + point.y; //生成唯一id
            if (roots[id] != -1) {
                //表示当前位置已经被设置过了
                result.add(landCnt);
                continue;
            }
            roots[id] = id;
            landCnt++;
            for (int[] direction : directions) {
                int row= point.x+direction[0];
                int col= point.y+direction[1];
                //row代表有多少行，需要乘上列的最大值，再加上处于的列数才是实际在数组中的位置
                int curId=row*m+col;
                if(row<0||row>=n||col<0||col>=m||roots[curId]==-1)
                    continue;
                int p=findRoots(roots,curId);
                if(p!=id){
                    //让另外的相邻的岛屿的根节点指向当前的岛屿，并将岛屿的个数-1
                    //也就是point周围的相邻的岛屿都指向point
                    roots[p]=id;
                    landCnt--;
                }
            }
            result.add(landCnt);
        }
        return result;
    }

    private int findRoots(int[] roots,int id){
        while(roots[id]!=id){
            id=roots[id];
        }
        return id;
    }

    public static void main(String[] args) {
        NumIslands numIslands = new NumIslands();

    }

    class Point {
        int x;
        int y;

        Point() {
            x = 0;
            y = 0;
        }

        Point(int a, int b) {
            x = a;
            y = b;
        }
    }
}
