package DynamicProgramming;

public class CountSubstrings {

    /**
     * 647 回文子串数量
     * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
     * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
     * 示例 1：
     * 输入："abc"
     * 输出：3
     * 解释：三个回文子串: "a", "b", "c"
     * 示例 2：
     * 输入："aaa"
     * 输出：6
     * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
     * 提示：
     * 输入的字符串长度不会超过 1000 。
     *
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        if (s == null || s.length() <= 0)
            return 0;
        int len = s.length();
        if (len <= 1)
            return 1;
        int[][] dp = new int[len][len];
        int result = len;
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = 2; i <= len; i++) {
            for (int j = i - 1; j < len; j++) {
                if(i==2){
                    if(s.charAt(j)==s.charAt(j-1)){
                        dp[j-1][j]=1;
                        result++;
                    }
                }else{
                    if(s.charAt(j)==s.charAt(j-i+1)&&dp[j-i+2][j-1]==1){
                        dp[j-i+1][j]=1;
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountSubstrings countSubstrings=new CountSubstrings();
        System.out.println(countSubstrings.countSubstrings("aaa"));
    }
}
