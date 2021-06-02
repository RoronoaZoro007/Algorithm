package SortAlgorithm;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSort=new MergeSort();
        System.out.println(Arrays.toString(mergeSort.sortArray(new int[]{3,4,3,2,1,4,6,7,0})));
    }

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length <= 1)
            return nums;
        mergeSort(nums,new int[nums.length],0,nums.length-1);
        return nums;
    }

    private void mergeSort(int[] nums, int[] temp,int start, int end) {
        if(start>=end){
            return;
        }
        int mid=start+(end-start)/2;
        mergeSort(nums,temp,start,mid);
        mergeSort(nums,temp,mid+1,end);
        int leftPos=start;
        int leftEnd=mid;
        int rightPos=mid+1;
        int rightEnd=end;
        int pos=start;
        while (leftPos<=leftEnd&&rightPos<=rightEnd){
            if(nums[leftPos]<=nums[rightPos]){
                temp[pos++]=nums[leftPos++];
            }else{
                temp[pos++]=nums[rightPos++];
            }
        }
        while (leftPos<=leftEnd){
            temp[pos++]=nums[leftPos++];
        }
        while (rightPos<=rightEnd){
            temp[pos++]=nums[rightPos++];
        }
        pos=start;
        while (pos<=end){
            nums[pos]=temp[pos];
            pos++;
        }
    }
}
