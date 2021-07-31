package String;

import java.util.Stack;

/**
 * 224 基本计算器
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * 示例 1：
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 */
public class Calculate {

    //核心思想：每遇到一个（都要计算一下当前这层括号外的整体正负基数，每遇到一个）都要将上一层括号外的基础基数去掉
    //例如：-（3+（4+5）） 第一个（外的整体基数为-1，压入栈中，第二个（外的整体基数为1*（stack.peek()）=-1；
    //第一个）后,stack.pop(),基数从-1变为-1;
    public int calculate(String s) {
        if (s == null || s.length() <= 0)
            return 0;
        //表示最外层的整体正负号
        Stack<Integer> outer = new Stack<>();
        //表示当前数字实际的正负号
        Stack<Integer> inner = new Stack<>();
        outer.push(1);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                if (inner.isEmpty()) {
                    outer.push(outer.peek());
                    inner.push(outer.peek());
                } else {
                    outer.push(inner.peek());
                }
            } else if (c == ')') {
                outer.pop();
            } else if (c >= '0' && c <= '9') {
                int start = i;
                while (start < s.length() && s.charAt(start) >= '0' && s.charAt(start) <= '9') {
                    start++;
                }
                int num = Integer.parseInt(s.substring(i, start));
                if (inner.isEmpty()) {
                    sum += (num * outer.peek());
                } else {
                    sum += (num * inner.pop());
                }
                i = start - 1;
            } else if (c == '+') {
                //内层
                inner.push(outer.peek());
            } else if (c == '-') {
                inner.push(outer.peek() * -1);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        System.out.println(calculate.calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(calculate.calculate(" 2-1 + 2 "));
        System.out.println(calculate.calculate("1 + 1"));
        System.out.println(calculate.calculate("-(3+(4+5))"));
    }
}
