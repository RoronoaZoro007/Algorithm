package DynamicProgramming;

public class LongestPalindrome {

    //最长回文子串 babad
    //变量startPos和endPos中间的字符串为回文字符串，因此是二维
    public String longestPalindrome(String s) {
        int len = s.length();
        int maxlen = 1;
        int startPos = 0;
        int endPos = 0;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        for (int j = 2; j <= len; j++) {//len
            for (int i = 0; i <= len - j; i++) {
                if (j == 2) {
                    if (s.charAt(i) == s.charAt(i + j - 1)) {
                        dp[i][i + j - 1] = 1;
                        if (j > maxlen) {
                            maxlen = j;
                            startPos = i;
                            endPos = i + j - 1;
                        }
                    }
                }else{
                    if(s.charAt(i) == s.charAt(i + j - 1)&&dp[i+1][i+j-2]==1){
                        dp[i][i + j - 1] = 1;
                        if (j > maxlen) {
                            maxlen = j;
                            startPos = i;
                            endPos = i + j - 1;
                        }
                    }
                }
            }
        }
        return s.substring(startPos, endPos + 1);
    }

    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("cccc"));
    }
}
