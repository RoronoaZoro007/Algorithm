package Arrays;

import java.util.Random;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 **/
public class FindKthLargest {

    public static void main(String[] args) {
        FindKthLargest findKthLargest=new FindKthLargest();
        System.out.println(findKthLargest.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }

    public int findKthLargest(int[] nums, int k) {
        if(nums==null||nums.length<=0||k<=0||k>nums.length)
            return Integer.MIN_VALUE;
        int start=0;
        int end=nums.length-1;
        int mid=0;
        k= nums.length-k;
        while(start<end){
            //以nums[mid]为中间值，左边的都比其小，右边的都比其大
            mid= partition(nums,start,end);
            if(mid==k){
                return nums[mid];
            }else if(mid>k){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return nums[k];
    }

    private int partition(int[] nums, int start, int end){
        if(start==end)
            return start;
        //生成一个start到end之间的随机数，将其与end交换，即以此随机数对应的数组元素为分界点
        //元素左边的都比其小，右边的都比其大
        Random random=new Random();
        int tempPos=random.nextInt(end-start+1)+start;
        swap(nums,tempPos,end);
        int temp=nums[end];
        while(start<end){
            //tips：注意此时是<=
            while (start<end&&nums[start]<=temp){
                start++;
            }
            if(start<end){
                swap(nums,start,end);
            }
            //tips:注意此时是>=,要加上一个=
            while(start<end&&nums[end]>=temp){
                end--;
            }
            if(start<end){
                swap(nums,start,end);
            }
        }
        return start;
    }

    private void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}
