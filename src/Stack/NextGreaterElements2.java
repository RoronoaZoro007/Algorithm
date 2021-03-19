package Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElements2 {

    /**
     * 503.给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
     * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
     * 示例 1:
     * 输入: [1,2,1]
     * 输出: [2,-1,2]
     * 解释: 第一个 1 的下一个更大的数是 2；
     * 数字 2 找不到下一个更大的数；
     * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length <= 0)
            return new int[0];
        Stack<Integer> stack = new Stack<>();
        int[] output = new int[nums.length];
        Arrays.fill(output, -1);
        for (int i = 0; i < 2 * nums.length - 1; i++) {
            int num = nums[i % nums.length];
            while (!stack.isEmpty() && nums[stack.peek() % nums.length] < num) {
                if (stack.peek() < nums.length) {
                    output[stack.pop()] = num;
                } else {
                    stack.pop();
                }
            }
            stack.push(i);
        }
        return output;
    }

    public static void main(String[] args) {
        NextGreaterElements2 nextGreaterElements2 = new NextGreaterElements2();
        System.out.println(Arrays.toString(nextGreaterElements2.nextGreaterElements(new int[]{1, 2, 1})));
    }
}
