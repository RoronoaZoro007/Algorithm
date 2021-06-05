package Stack;

import java.util.Stack;

public class Calculate_2 {

    /**
     * 227.基本计算器2
     * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
     * 整数除法仅保留整数部分。
     * 示例 1：
     * 输入：s = "3+2*2"
     * 输出：7
     * 示例 2：
     * 输入：s = " 3/2 "
     * 输出：1
     * 1 <= s.length <= 3 * 105
     * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
     * s 表示一个 有效表达式
     * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
     * 题目数据保证答案是一个 32-bit 整数
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        s = s.trim();
        Stack<Integer> stack = new Stack<>();
        Stack<Character> stack1 = new Stack<>();
        int start = 0;
        int curr = 0;
        while (curr < s.length()) {
            while (curr < s.length()
                    && s.charAt(curr) != '+' && s.charAt(curr) != '-' && s.charAt(curr) != '*' && s.charAt(curr) != '/') {
                curr++;
            }
            int val = Integer.parseInt(s.substring(start, curr).trim());
            if (!stack1.isEmpty()) {
                if (stack1.peek() == '*') {
                    stack1.pop();
                    stack.push(stack.pop() * val);
                } else if (stack1.peek() == '/') {
                    stack1.pop();
                    stack.push(stack.pop() / val);
                } else {
                    stack.push(val);
                }
            } else {
                stack.push(val);
            }
            if (curr == s.length()) {
                break;
            }
            char c = s.charAt(curr);
            stack1.push(c);
            curr++;
            start = curr;
        }
        int sum = 0;
        while (!stack1.isEmpty()) {
            int val = stack.pop();
            sum += stack1.pop() == '+' ? val : -1 * val;
        }
        sum += stack.pop();
        return sum;
    }

    public static void main(String[] args) {
        Calculate_2 calculate_2 = new Calculate_2();
        System.out.println(calculate_2.calculate("3+5 /2"));
    }
}
