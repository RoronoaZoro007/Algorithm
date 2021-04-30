package Arrays;

import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        NextPermutation nextPermutation=new NextPermutation();
        int[] nums=new int[]{1,3,2};
        nextPermutation.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        if(nums==null||nums.length<=1)
            return;
        int i;
        //从末尾开始往前找，找升序的转折点
        for(i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1])
                break;
        }
        //从尾到头都是升序的，直接翻转
        if(i<0){
            //翻转数组
            reverseArray(0,nums.length-1,nums);
            return;
        }
        //maxPos为实际的转折点
        int maxPos=i+1;
        //找转折点右边比左边第一个数大的最小的数
        for(int j=maxPos+1;j<nums.length;j++){
            if(nums[j]>nums[i]){
                maxPos=j;
            }else{
                break;
            }
        }
        //交换i和maxPos的值
        int temp=nums[i];
        nums[i]=nums[maxPos];
        nums[maxPos]=temp;
        //翻转i位置之后的序列，即变为最小排列
        reverseArray(i+1,nums.length-1,nums);
    }

    private void reverseArray(int start,int end,int[] arr){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}
