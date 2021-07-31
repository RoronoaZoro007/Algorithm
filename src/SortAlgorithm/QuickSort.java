package SortAlgorithm;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    //快排
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1)
            return nums;
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end)
            return;
        int partition = partition(nums, start, end);
        quickSort(nums, start, partition - 1);
        quickSort(nums, partition + 1, end);
    }

    //左边都小于等于它；右边都大于等于它
    public int partition(int[] nums, int start, int end) {
        if (start >= end)
            return start;
        Random random = new Random();
        int pos = random.nextInt(end - start + 1) + start;
        int temp = nums[pos];
        swap(nums, pos, end);
        while (start < end) {
            while (start < end && nums[start] <= temp) {
                start++;
            }
            swap(nums, start, end);
            while (start < end && nums[end] >= temp) {
                end--;
            }
            swap(nums, start, end);
        }
        return start;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        System.out.println(quickSort.partition(new int[]{2,0,1,3,2,4,5,6,3},0,8));
        System.out.println(Arrays.toString(quickSort.sortArray(new int[]{5,3,2,1,3,2,4,32,4,2324,54})));
    }
}
