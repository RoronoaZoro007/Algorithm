package GreedyAlgorithm;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 402.移除k位数
 * 给定一个以字符串表示的非负整数num，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 注意:
 * num 的长度小于 10002 且≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 */
public class RemoveKdigits {


    public String removeKdigits(String num, int k) {
        if(num==null||num.length()<=0||num.length()<=k)
            return "0";
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            //维持一个升序序列，当不符合条件时，将前面的大的数出栈
            while (!deque.isEmpty() && c < deque.peekLast() && k > 0) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(c);
        }
        //全是升序的序列，k还大于0，那么从尾部开始移除
        while (k > 0 && !deque.isEmpty()) {
            deque.pollLast();
            k--;
        }
        StringBuilder result = new StringBuilder();
        while (!deque.isEmpty()) {
            result.append(deque.pollFirst());
        }
        while (result.length() >= 1 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }
        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        RemoveKdigits removeKdigits = new RemoveKdigits();
        int n;

        System.out.println(removeKdigits.removeKdigits("10", 1));
    }
}
