package Stack;

public class NextGreaterElements3 {

    /**
     * 556.给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
     * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
     * 示例 1：
     * 输入：n = 12
     * 输出：21
     * 示例 2：
     * 输入：n = 21
     * 输出：-1
     *
     * @param n
     * @return
     */
    public int nextGreaterElement(int n) {
        if (n < 10)
            return -1;
        char[] chars = ("" + n).toCharArray();
        int pos = -1;
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i] > chars[i - 1]) {
                pos = i - 1;
                break;
            }
        }
        if (pos == -1) {
            return -1;
        }
        int minMaxPos = pos + 1;
        for (int i = chars.length - 1; i >= pos + 1; i--) {
            if (chars[i] > chars[pos]) {
                minMaxPos = i;
                break;
            }
        }
        reverse(chars, pos, minMaxPos);
        for (int i = pos + 1; i <= (pos + chars.length) / 2; i++) {
            reverse(chars, i, (pos + chars.length - i));
        }
        try {
            return Integer.parseInt(new String(chars));
        } catch (Exception e) {
            return -1;
        }
    }

    public void reverse(char[] chars, int posx, int posy) {
        char c = chars[posx];
        chars[posx] = chars[posy];
        chars[posy] = c;
    }

    public static void main(String[] args) {
        NextGreaterElements3 nextGreaterElements3 = new NextGreaterElements3();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(nextGreaterElements3.nextGreaterElement(230241));
    }
}
