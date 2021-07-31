package Stack;

import java.util.Stack;

/**
 * 150 逆波兰表达式
 * 根据 逆波兰表示法，求表达式的值。
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * 说明：
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 * 示例 1：
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例 2：
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {
        if(tokens==null||tokens.length<=0){
            return 0;
        }
        Stack<Integer> stack=new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            int num2;
            int num1;
            switch (tokens[i]){
                case "+":
                    num2=stack.pop();
                    num1=stack.pop();
                    stack.push(num1+num2);
                    break;
                case "-":
                    num2=stack.pop();
                    num1=stack.pop();
                    stack.push(num1-num2);
                    break;
                case "*":
                    num2=stack.pop();
                    num1=stack.pop();
                    stack.push(num1*num2);
                    break;
                case "/":
                    num2=stack.pop();
                    num1=stack.pop();
                    stack.push(num1/num2);
                    break;
                default:
                    stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }
}
