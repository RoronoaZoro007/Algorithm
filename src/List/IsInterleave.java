package List;

/**
 * 97 交错字符串
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 * <p>
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * <p>
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 提示：a + b 意味着字符串 a 和 b 连接。
 * 示例 1：
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 * example2
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出：false
 * <p>
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1、s2、和 s3 都由小写英文字母组成
 */
public class IsInterleave {

    //使用双指针错误解答，应使用动态规划，s1的前i个，和s2的前j个能否组成s3的前i+j个字符
    public boolean isInterleave_wrong(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null)
            return false;
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if (len1 + len2 != len3)
            return false;
        int pos1 = 0;
        int pos2 = 0;
        int pos3 = 0;
        while (pos1 < len1 && pos2 < len2) {
            if (s1.charAt(pos1) == s3.charAt(pos3)) {
                pos1++;
                pos3++;
            } else if (s2.charAt(pos2) == s3.charAt(pos3)) {
                pos2++;
                pos3++;
            } else {
                break;
            }
        }
        while (pos1 < len1 && s1.charAt(pos1) == s3.charAt(pos3)) {
            pos1++;
            pos3++;
        }
        while (pos2 < len2 && s2.charAt(pos2) == s3.charAt(pos3)) {
            pos2++;
            pos3++;
        }
        return pos3 == len3;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null)
            return false;
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1+len2!=s3.length())
            return false;
        //该dp数组表示s1的前i个字符与s2的前j个字符，能否组成s3的前（i+j）个字符
        boolean[][] canCompose = new boolean[len1 + 1][len2 + 1];
        canCompose[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                canCompose[i][0] = canCompose[i - 1][0];
            } else {
                break;
            }
        }
        for (int i = 1; i <= len2; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1)) {
                canCompose[0][i] = canCompose[0][i-1];
            } else {
                break;
            }
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                canCompose[i][j] = (s1.charAt(i - 1) == s3.charAt(i + j - 1) && canCompose[i - 1][j]) ||
                        (s2.charAt(j - 1) == s3.charAt(i + j - 1) && canCompose[i][j - 1]);
            }
        }
        return canCompose[len1][len2];
    }

    public boolean isInterleave_1(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length(), t = s3.length();

        if (n + m != t) {
            return false;
        }

        boolean[][] f = new boolean[n + 1][m + 1];

        f[0][0] = true;
        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }

        return f[n][m];
    }

    public static void main(String[] args) {
        IsInterleave isInterleave = new IsInterleave();
        System.out.println(isInterleave.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
