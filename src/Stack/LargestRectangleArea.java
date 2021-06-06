package Stack;

import java.util.Stack;

public class LargestRectangleArea {

    /**
     * 84.柱状图中的最大矩形面积
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * <p>
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     * X
     *      X X
     * X X
     * X X   X
     * X   X X X X
     * X X X X X X
     * 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length <= 0)
            return 0;
        int[] leftMinPos = new int[heights.length];
        int[] rightMinPos = new int[heights.length];
        //保存的是以当前curr为结束位置的一个升序序列
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> rightStack = new Stack<>();
        int curr = 0;
        leftStack.push(0);
        while (curr < heights.length) {
            //可能存在当前就是最大值的情况，需要先设置一下初始值
            while (!leftStack.isEmpty() && heights[leftStack.peek()] >= heights[curr]) {
                leftStack.pop();
            }
            leftMinPos[curr] = leftStack.isEmpty() ? -1 : leftStack.peek();
            leftStack.add(curr);
            curr++;
        }
        curr = heights.length - 1;
        rightStack.push(heights.length - 1);
        int maxVal = 0;
        while (curr >= 0) {
            //存在可能当前值就是最大值的情况，需要先设置一下初始值
            while (!rightStack.isEmpty() && heights[rightStack.peek()] >= heights[curr]) {
                rightStack.pop();
            }
            rightMinPos[curr] = rightStack.isEmpty() ? heights.length : rightStack.peek();
            rightStack.push(curr);
            maxVal = Math.max(maxVal, (rightMinPos[curr] - leftMinPos[curr] - 2 + 1) * heights[curr]);
            curr--;
        }
        return maxVal;
    }

    public static void main(String[] args) {
        LargestRectangleArea largestRectangleArea = new LargestRectangleArea();
        System.out.println(largestRectangleArea.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
