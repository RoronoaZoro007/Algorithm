package Queue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 862、和至少为K的最短子数组
 * 返回 A 的最短的非空连续子数组的长度，该子数组的和至少为 K 。
 * 如果没有和至少为 K 的非空子数组，返回 -1 。
 * 示例 1：
 * 输入：A = [1], K = 1
 * 输出：1
 * 示例 2：
 * 输入：A = [1,2], K = 4
 * 输出：-1
 * 示例 3：
 * 输入：A = [2,-1,2], K = 3
 * 输出：3
 * 1 <= A.length <= 50000
 * -10 ^ 5 <= A[i] <= 10 ^ 5
 * 1 <= K <= 10 ^ 9
 */
public class ShortestSubarray {

    public int shortestSubarray(int[] nums, int k) {
        if (nums == null || nums.length <= 0)
            return -1;
        int[] prefix = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        //维护一个前缀和单调递增的队列，存放的是前缀和数组中的pos
        Deque<Integer> queue = new LinkedList<>();
        int minPrefix=Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length; i++) {
            //因为要维持队列的单调性，必须要将队尾比当前前缀和大的数值给移除
            while(!queue.isEmpty()&&prefix[i]<=prefix[queue.peekLast()]){
                queue.pollLast();
            }
            //因为是单调队列，如果当前位置前缀和与队列头部最小前缀和的差值比k大的话，是满足条件的
            //但是这不是最优解，需要找到一个最大的前缀和的位置，使得两者之差大于k
            while (!queue.isEmpty()&&prefix[i]-prefix[queue.peekFirst()]>=k){
                minPrefix=Math.min(minPrefix,i-queue.pollFirst());
            }
            queue.add(i);
        }
        return minPrefix==Integer.MAX_VALUE?-1:minPrefix;
    }
}
