package SortAlgorithm;

import java.util.Arrays;

public class InsertSort {


    public static void main(String[] args) {
        InsertSort insertSort=new InsertSort();
        System.out.println(Arrays.toString(insertSort.sortArray(new int[]{3,4,3,2,1,4,6,7,0})));
    }
    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1)
            return nums;
        int len=nums.length;
        for (int i = 0; i < len-1; i++) {
            int temp=nums[i+1];
            int j=i;
            while (j>=0&&nums[j]>temp){
                nums[j+1]=nums[j];
                j--;
            }
            nums[++j]=temp;
        }
        return nums;
    }
}
