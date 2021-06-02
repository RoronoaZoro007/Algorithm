package SortAlgorithm;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {
        SelectSort selectSort=new SelectSort();
        System.out.println(Arrays.toString(selectSort.sortArray(new int[]{3,4,3,2,1,4,6,7,0})));
    }

    public int[] sortArray(int[] nums) {
        if(nums==null||nums.length<=1)
            return nums;
        int len=nums.length;
        for (int i = 0; i < len; i++) {
            int min=nums[i];
            for (int j = i+1; j <len ; j++) {
                if(nums[j]<nums[i])
                    swap(nums,i,j);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
