package SortAlgorithm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class HeapSort {

    public String minNumber(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1 = o1.toString();
                String s2 = o2.toString();
                return (s1 + s2).compareTo(s2 + s1);
            }
        });
        for (int num : nums) {
            priorityQueue.offer(num);
        }
        StringBuilder sb=new StringBuilder();
        while (!priorityQueue.isEmpty()){
            sb.append(priorityQueue.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        System.out.println(heapSort.minNumber(new int[]{3,30,34,5,9}));
        System.out.println(Arrays.toString(heapSort.sortArray(new int[]{3, 4, 3, 2, 1, 4, 6, 7, 0})));
    }

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1)
            return nums;
        int beginIndex = (nums.length - 1) >> 1;
        for (int i = beginIndex; i >= 0; i--) {
            maxHeapify(nums, i, nums.length - 1);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            swap(nums, 0, i);
            maxHeapify(nums, 0, i - 1);
        }
        return nums;
    }


    private void maxHeapify(int[] nums, int index, int len) {
        int left = (index << 1) + 1;
        int right = left + 1;
        int maxPos = left;
        if (left > len)
            return;
        if (right <= len) {
            maxPos = nums[right] > nums[left] ? right : maxPos;
        }
        if (nums[maxPos] > nums[index]) {
            swap(nums, maxPos, index);
            maxHeapify(nums, maxPos, len);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
