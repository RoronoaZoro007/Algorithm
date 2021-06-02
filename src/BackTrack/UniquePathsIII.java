package BackTrack;

public class UniquePathsIII {

    /**
     * 980、不同路径3
     * 在二维网格 grid 上，有 4 种类型的方格：
     * 1 表示起始方格。且只有一个起始方格。
     * 2 表示结束方格，且只有一个结束方格。
     * 0 表示我们可以走过的空方格。
     * -1 表示我们无法跨越的障碍。
     * 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。
     * 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。
     * 示例 1：
     * 输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
     * 输出：2
     * 解释：我们有以下两条路径：
     * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
     * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
     * @param grid
     * @return
     */
    int[][] direction;
    int result;
    int row;
    int col;
    public int uniquePathsIII(int[][] grid) {
        if(grid==null||grid.length<=0||grid[0].length<=0)
            return 0;
        int startX=0;
        int startY=0;
        int noBarryCnt=0;
        row=grid.length;
        col=grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(grid[i][j]==0){
                    noBarryCnt++;
                }else if(grid[i][j]==1){
                    startX=i;
                    startY=j;
                }
            }
        }
        boolean[][] isVisited=new boolean[row][col];
        result=0;
        direction=new int[][]{{-1,1,0,0},{0,0,-1,1}};
        //因为起始位置也算是一次访问
        noBarryCnt++;
        backtrack(startX,startY,noBarryCnt,grid,isVisited);
        return result;
    }

    private void backtrack(int posX,int posY,int noBarryCnt,int[][] grid,boolean[][] isVisited){
        if(posX<0||posX>=row||posY<0||posY>=col)
            return;
        if(isVisited[posX][posY]||grid[posX][posY]==-1)
            return;
        if(grid[posX][posY]==2){
            if(noBarryCnt==0)
                result++;
            return;
        }
        for (int i = 0; i < 4; i++) {
           int newX=posX+direction[0][i];
           int newY=posY+direction[1][i];
           if(newX >= 0 && newX < row && newY >= 0 && newY < col){
               isVisited[posX][posY]=true;
               backtrack(newX,newY,noBarryCnt-1,grid,isVisited);
               isVisited[posX][posY]=false;
           }
        }
    }

    public static void main(String[] args) {
        UniquePathsIII uniquePathsIII=new UniquePathsIII();
        System.out.println(uniquePathsIII.uniquePathsIII(new int[][]{{1,0,0,0},{0,0,0,0},{0,0,2,-1}}));
    }
}
