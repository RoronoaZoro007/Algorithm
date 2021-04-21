package DynamicProgramming;

public class NumDecodings {

    /**
     * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
     * 'A' -> 1
     * 'B' -> 2
     * ...
     * 'Z' -> 26
     * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
     * "AAJF" ，将消息分组为 (1 1 10 6)
     * "KJF" ，将消息分组为 (11 10 6)
     * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
     * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
     * 题目数据保证答案肯定是一个 32 位 的整数。
     * tip:由于变化的只有字符串的长度，所以dp是一维的
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s == null || s.length() <= 0)
            return 0;
        int[] dp = new int[s.length() + 1];
        if (s.charAt(0) == '0')
            return 0;
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i - 1) == '0') {
                if (isOuterValue(s, i))
                    return 0;
                dp[i] = dp[i - 2];
            } else {
                if (s.charAt(i - 2) == '0') {
                    dp[i] = dp[i - 1];
                } else if (isOuterValue(s, i)) {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = dp[i - 2] + dp[i - 1];
                }
            }
        }
        return dp[s.length()];
    }

    private boolean isOuterValue(String s, int i) {
        Integer sub = Integer.valueOf(s.substring(i - 2, i));
        return sub < 1 || sub > 26;
    }

    public static void main(String[] args) {
        NumDecodings numDecodings = new NumDecodings();
        System.out.println(Integer.valueOf("02"));
        System.out.println(numDecodings.numDecodings("10011"));
    }
}
