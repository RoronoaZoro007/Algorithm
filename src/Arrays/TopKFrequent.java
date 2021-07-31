package Arrays;

import java.util.*;

public class TopKFrequent {

    /**
     * 347 前k个高频元素
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
     * 示例 1:
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * 示例 2:
     * 输入: nums = [1], k = 1
     * 输出: [1]
     * 提示：
     * 1 <= nums.length <= 105
     * k 的取值范围是 [1, 数组中不相同的元素的个数]
     * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length <= 0 || k <= 0) {
            return new int[0];
        }
        //用来保存元素出现的频率
        HashMap<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
        }
        //通过堆排序来对数字出现的频次进行排序（只需要维持一个大小为K的大顶堆即可）
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return cntMap.get(o2) - cntMap.get(o1);
            }
        });
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            priorityQueue.add(entry.getKey());
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = priorityQueue.isEmpty() ? 0 : priorityQueue.poll();
        }
        return result;
    }
}
