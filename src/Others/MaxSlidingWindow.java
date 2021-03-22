package Others;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow {

    /**
     * 239.滑动窗口最大值
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= 0)
            return new int[0];
        Deque<Integer> queue = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() &&
                    nums[i] >= nums[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.add(i);
            if (i >= k - 1) {
                while (!queue.isEmpty() &&
                        queue.peekFirst() < i - (k - 1)) {
                    queue.pollFirst();
                }
                result[i - (k - 1)] = nums[queue.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        System.out.println(Arrays.toString(maxSlidingWindow.maxSlidingWindow(new int[]{1, -1}, 1)));
    }
}
