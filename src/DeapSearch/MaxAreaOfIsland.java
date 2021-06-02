package DeapSearch;

public class MaxAreaOfIsland {

    /**
     * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
     * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。
     * 你可以假设 grid 的四个边缘都被 0（代表水）包围着。
     * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
     * 示例 1:
     * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
     *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
     *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
     *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
     *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
     *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
     *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
     *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
     * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
     */

    public static void main(String[] args) {
        MaxAreaOfIsland maxAreaOfIsland=new MaxAreaOfIsland();
        System.out.println(maxAreaOfIsland.maxAreaOfIsland(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0}}));
    }
    public int maxAreaOfIsland(int[][] grid) {
        if(grid==null||grid.length<=0||grid[0].length<=0)
            return 0;
        int maxCnt=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1){
                    maxCnt=Math.max(maxCnt,deapSearch(grid,i,j));
                }
            }
        }
        return maxCnt;
    }
    
    int[][] direction=new int[][]{{-1,1,0,0},{0,0,-1,1}};
    private int deapSearch(int[][] grid,int posX,int posY){
        if(posX<0||posX>=grid.length||posY<0||posY>=grid[0].length)
            return 0;
        if(grid[posX][posY]==0)
            return 0;
        int cnt=1;
        for (int i = 0; i < 4; i++) {
            grid[posX][posY]=0;
            cnt+=deapSearch(grid,posX+direction[0][i],posY+direction[1][i]);
        }
        return cnt;
    }
}
