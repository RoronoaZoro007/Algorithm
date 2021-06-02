package Arrays;

import java.util.Arrays;

public class GenerateMatrix {

    public static void main(String[] args) {
        GenerateMatrix generateMatrix=new GenerateMatrix();
        int[][] temp=generateMatrix.generateMatrix(6);
        for(int[] val:temp){
            System.out.println(Arrays.toString(val));
        }
    }

    public int[][] generateMatrix(int n) {
        if (n <= 0)
            return new int[0][0];
        int[][] out = new int[n][n];
        //方向顺序依此为，向右；向下；向左；向上
        int[][] direction = new int[][]{{0, 1, 0, -1}, {1, 0, -1, 0}};
        boolean[][] isVisited = new boolean[n][n];
        int currX = 0;
        int currY = 0;
        int currVal = 1;
        while (currVal <= n * n) {
            for (int i = 0; i < 4; i++) {
                while (isValid(currX,currY,n)&&!isVisited[currX][currY]){
                    out[currX][currY]=currVal;
                    isVisited[currX][currY]=true;
                    currX+=direction[0][i];
                    currY+=direction[1][i];
                    currVal++;
                }
                //不符合条件，要先回到上一位置
                currX-=direction[0][i];
                currY-=direction[1][i];
                //回到上一符合条件的位置，然后调整方向
                currX+=direction[0][(i+1)%4];
                currY+=direction[1][(i+1)%4];
            }
        }
        return out;
    }

    private boolean isValid(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
