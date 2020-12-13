package Arrays;

/**
 * 在一个 8 x 8 的棋盘上，有一个白色的车（Rook），用字符 'R' 表示。棋盘上还可能存在空方块，白色的象（Bishop）以及黑色的卒（pawn），
 * 分别用字符 '.'，'B' 和 'p' 表示。不难看出，大写字符表示的是白棋，小写字符表示的是黑棋。
 *
 * 车按国际象棋中的规则移动。东，西，南，北四个基本方向任选其一，然后一直向选定的方向移动，直到满足下列四个条件之一：
 *
 * 棋手选择主动停下来。
 * 棋子因到达棋盘的边缘而停下。
 * 棋子移动到某一方格来捕获位于该方格上敌方（黑色）的卒，停在该方格内。
 * 车不能进入/越过已经放有其他友方棋子（白色的象）的方格，停在友方棋子前。
 * 你现在可以控制车移动一次，请你统计有多少敌方的卒处于你的捕获范围内（即，可以被一步捕获的棋子数）
 *
 */
public class NumRookCaptures {
    public static void main(String[] args) {
        System.out.println(numRookCaptures(new char[][]{{'a','b'},{'c','R'}}));
    }

    public static int numRookCaptures(char[][] board) {
        if (board == null || board.length <= 0) {
            return 0;
        }
        int[][] gap = new int[][]{{-1, 1, 0, 0}, {0, 0, -1, 1}};
        int posx = 0;
        int posy = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if ('R' == (board[i][j])) {
                    posx = i;
                    posy = j;
                    break;
                }
            }
            if (posx != 0)
                break;
        }
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nowPosX = posx;
            int nowPosY = posy;
            while (true) {
                nowPosX += gap[0][i];
                nowPosY += gap[1][i];
                if (nowPosX < 0 || nowPosX >= board.length || nowPosY < 0 || nowPosY >= board[nowPosX].length)
                    break;
                if ('B' == board[nowPosX][nowPosY])
                    break;
                else if ('p' == board[nowPosX][nowPosY]) {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
}
