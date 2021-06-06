package Stack;

import java.util.Stack;

public class DecodeString {

    /**
     * 394.字符串解码
     * 给定一个经过编码的字符串，返回它解码后的字符串。
     * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
     * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
     * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
     * 示例 1：
     * 输入：s = "3[a]2[bc]"
     * 输出："aaabcbc"
     * 示例 2：
     * 输入：s = "3[a2[c]]"
     * 输出："accaccacc"
     * 示例 3：
     * 输入：s = "2[abc]3[cd]ef"
     * 输出："abcabccdcdcdef"
     * 示例 4：
     * 输入：s = "abc3[cd]xyz"
     * 输出："abccdcdcdxyz"
     *
     * @param s
     * @return
     */
    public String decodeString(String s) {
        if (s == null || s.length() <= 0)
            return s;
        s = s.toLowerCase();
        Stack<Integer> count = new Stack<>();
        Stack<String> segmentString = new Stack<>();
        int startPos = 0;
        int curr = 0;
        //比如说aa2[bc]中的tempString就是aa，tempNumber就是2
        //到[时，aa和2分别入栈
        //到]时，就用count的pop的次数乘上当前的tempString——bc，然后再前面拼接上segmentString的pop
        //tip:因为可能存在次数为1的情况，此种情况会被省略，因此添加一个默认值1
        //tip2:当当前的]出到最后一个时，就需要将其拼接到结果中
        int tempNumber = 1;
        String tempString = "";
        String result = "";
        while (curr < s.length()) {
            char c = s.charAt(curr);
            if (c >= '0' && c <= '9') {
                while (curr < s.length() && s.charAt(curr) >= '0' && s.charAt(curr) <= '9') {
                    curr++;
                }
                tempNumber = Integer.parseInt(s.substring(startPos, curr));
                startPos = curr;
            } else if (c >= 'a' && c <= 'z') {
                while (curr < s.length() && s.charAt(curr) >= 'a' && s.charAt(curr) <= 'z') {
                    curr++;
                }
                //tip:需要将前一部分保存的tempString拼接到其首部，然后在其尾部添加新的遍历到的字符串，
                //在后续遍历到[的时候添加到栈中
                tempString = tempString + s.substring(startPos, curr);
                startPos = curr;
            } else if (c == '[') {
                count.add(tempNumber);
                segmentString.add(tempString);
                //需要初始化为1和""
                tempNumber = 1;
                tempString = "";
                curr++;
                startPos = curr;
            } else if (c == ']') {
                //因为可能存在a3[abc2[ab]cd4[f]]这种情况，一个中括号里面有多个子中括号
                //需要将abcabab保存下来，然后再下次到字母时添加到其首部！
                tempString = segmentString.pop() + tempString.repeat(count.pop());
                if (count.isEmpty()) {
                    result = result + tempString;
                    tempString = "";
                    tempNumber = 1;
                }
                curr++;
                startPos = curr;
            }
        }
        return result + tempString;
    }

    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        System.out.println(decodeString.decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
    }

}
