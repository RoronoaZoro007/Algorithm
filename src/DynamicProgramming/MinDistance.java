package DynamicProgramming;

/**
 * 72、编辑距离
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * 示例 1：
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 */
public class MinDistance {

    public static void main(String[] args) {
        MinDistance minDistance=new MinDistance();
        System.out.println(minDistance.minDistance("intention","execution"));
    }

    public int minDistance(String word1, String word2) {
        if (word1.length() == 0 || word2.length() == 0)
            return word1.length() == 0 ? word2.length() : word1.length();
        int len1=word1.length();
        int len2=word2.length();
        int[][] dp=new int[len1+1][len2+1];
        for (int i = 0; i <= len2; i++) {
            dp[0][i]=i;
        }
        for (int i = 0; i <=len1; i++) {
            dp[i][0]=i;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    //i-1 是word1删除最后一个字母
                    //j-1 是word1插入一个和word2[j-1]相同的字母
                    //i-1 j-1 是直接将word1[i-1]转变成word2[j-1]
                    //以上都要变一次
                    dp[i][j]=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;
                }
            }
        }
        return dp[len1][len2];
    }
}
