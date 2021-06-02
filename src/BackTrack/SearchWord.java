package BackTrack;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 输入：board = [
 * ["A","B","C","E"],
 * ["S","F","C","S"],
 * ["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 */
public class SearchWord {

    public static void main(String[] args) {
        SearchWord searchWord=new SearchWord();
        char[][] arr=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};

        System.out.println(searchWord.exist(new char[][]{{'A'}},"A"));
    }

    int[][] direct=new int[][]{{-1,1,0,0},{0,0,-1,1}};

    public boolean exist(char[][] board, String word) {
        if(board==null||word==null)
            return false;
        int row=board.length;
        int col=board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(getResult(board,new boolean[row][col],i,j,word,0))
                    return true;
            }
        }
        return false;
    }

    private boolean getResult(char[][] board,boolean[][] isUsed,int posx,int posy,String word,int nowLen){
        if(nowLen==word.length())
            return true;
        if (posx<0||posx>=board.length||posy<0||posy>=board[0].length)
            return false;
        if(isUsed[posx][posy])
            return false;
        if(board[posx][posy]!=word.charAt(nowLen))
            return false;
        boolean val=false;
        isUsed[posx][posy]=true;
        for (int i = 0; i < 4; i++) {
            val= getResult(board,isUsed,posx+direct[0][i],posy+direct[1][i],word,nowLen+1);
            if (val)
                break;;
        }
        isUsed[posx][posy]=false;
        return val;
    }
}
