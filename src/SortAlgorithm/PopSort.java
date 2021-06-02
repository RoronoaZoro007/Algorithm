package SortAlgorithm;

import java.util.Arrays;

public class PopSort {

    public static void main(String[] args) {
        PopSort popSort=new PopSort();
        System.out.println(Arrays.toString(popSort.sortArray(new int[]{3,4,3,2,1,4,6,7,0})));
    }

    public int[] sortArray(int[] nums){
        if(nums==null||nums.length<=1)
            return nums;
        int len=nums.length;
        for (int i = len-1; i >=0 ; i--) {
            for (int j = 0; j < i; j++) {
                if(nums[j]>nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
        return nums;
    }

    private void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}
