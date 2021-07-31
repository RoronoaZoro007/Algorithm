package String;

/**
 * 6 Z型变化
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * 请你实现这个将字符串进行指定行数变换的函数：
 * string convert(string s, int numRows);
 * 示例 1：
 * 输入：s = "PAYPALISHIRING", numRows = 3
 * 输出："PAHNAPLSIIGYIR"
 * 示例 2：
 * 输入：s = "PAYPALISHIRING", numRows = 4
 * 输出："PINALSIGYAHRPI"
 * 解释：
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * 示例 3：
 * 输入：s = "A", numRows = 1
 * 输出："A"
 */
public class ConvertZ {


    /*
        0      6        12
        1    5 7     11 13
        2  4   8  10
        3      9
        对应的每一组的长度为2*numRows-2，非首尾，有两个字母，分别是headPos+i和nextHeadPos（等价于headPos+每组的长度）-i
     */
    public String convert(String s, int numRows) {
        if (s == null || s.length() <= numRows || numRows <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int len = 2 * numRows - 2;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; i + j < s.length(); j = j + len) {
                sb.append(s.charAt(i + j));
                if (i != 0 && i != numRows - 1 && (j + len - i) < s.length()) {
                    sb.append(s.charAt(j + len - i));
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ConvertZ convertZ=new ConvertZ();
        System.out.println(convertZ.convert("PAYPALISHIRING",4));
    }
}
