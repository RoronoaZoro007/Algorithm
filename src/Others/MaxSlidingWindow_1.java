package Others;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaxSlidingWindow_1 {

    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
     * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * 返回滑动窗口中的最大值。
     * 示例 1：
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     * 解释：
     * 滑动窗口的位置                最大值
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7       3
     * 1  3 [-1  -3  5] 3  6  7       5
     * 1  3  -1 [-3  5  3] 6  7       5
     * 1  3  -1  -3 [5  3  6] 7       6
     * 1  3  -1  -3  5 [3  6  7]      7
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k <= 0)
            return new int[0];
        if (k >= nums.length) {
            return new int[]{Arrays.stream(nums).max().getAsInt()};
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
                    deque.pollLast();
                deque.add(i);
                continue;
            }
            result[i - k] = nums[deque.peekFirst()];
            while (!deque.isEmpty() && (i - deque.peekFirst()) >= k)
                deque.pollFirst();
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
                deque.pollLast();
            deque.add(i);
        }
        result[nums.length - k] = nums[deque.peekFirst()];
        return result;
    }

    public int[] maxSlidingWindow_1(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k <= 0)
            return new int[0];
        if (k >= nums.length) {
            return new int[]{Arrays.stream(nums).max().getAsInt()};
        }
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()])
                deque.pollLast();
            deque.add(i);
            if(i>=k-1){
                while (!deque.isEmpty() && (i - deque.peekFirst()) >= k)
                    deque.pollFirst();
                result[i-k+1]=nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSlidingWindow_1 maxSlidingWindow_1 = new MaxSlidingWindow_1();
        System.out.println(Arrays.toString(maxSlidingWindow_1.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
    }
}
