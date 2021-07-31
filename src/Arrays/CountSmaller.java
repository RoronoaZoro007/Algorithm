package Arrays;

import java.util.ArrayList;
import java.util.List;

public class CountSmaller {

    /**
     * 315 计算右侧小于当前元素的个数
     * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质：
     * counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
     * 示例：
     * 输入：nums = [5,2,6,1]
     * 输出：[2,1,1,0]
     * 解释：
     * 5 的右侧有 2 个更小的元素 (2 和 1)
     * 2 的右侧仅有 1 个更小的元素 (1)
     * 6 的右侧有 1 个更小的元素 (1)
     * 1 的右侧有 0 个更小的元素
     * 提示：
     * 0 <= nums.length <= 10^5
     * -10^4 <= nums[i] <= 10^4
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        if(nums==null||nums.length<=0){
            return new ArrayList<>();
        }
        //元素的pos，实际排序的是元素的pos，实际的元素值不变
        int[] numPos=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numPos[i]=i;
        }
        //当前这个位置右侧比其小的元素的个数
        int[] smallerCnt=new int[nums.length];
        //归并排序的临时存储的数组
        int[] tempNumPos=new int[nums.length];
        merge(nums,numPos,tempNumPos,smallerCnt,0,nums.length-1);
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<smallerCnt.length;i++){
            result.add(smallerCnt[i]);
        }
        return result;
    }

    private void merge(int[] nums,int[] numPos,int[] tempNumPos,int[] smallerCnt,int startPos,int endPos){
        if(startPos>=endPos){
            return;
        }
        int mid=startPos+(endPos-startPos)/2;
        merge(nums,numPos,tempNumPos,smallerCnt,startPos,mid);
        merge(nums,numPos,tempNumPos,smallerCnt,mid+1,endPos);
        int leftPos=startPos;
        int leftEnd=mid;
        int rightPos=mid+1;
        int rightEnd=endPos;
        int pos=startPos;
        while (leftPos<=leftEnd&&rightPos<=rightEnd){
            if(nums[numPos[leftPos]]>nums[numPos[rightPos]]){
                tempNumPos[pos]=numPos[leftPos];
                smallerCnt[numPos[leftPos]]+=(rightEnd-rightPos+1);
                pos++;
                leftPos++;
            }else{
                tempNumPos[pos]=numPos[rightPos];
                pos++;
                rightPos++;
            }
        }
        while (leftPos<=leftEnd){
            tempNumPos[pos++]=numPos[leftPos++];
        }
        while(rightPos<=rightEnd){
            tempNumPos[pos++]=numPos[rightPos++];
        }
        pos=startPos;
        while (pos<=endPos){
            numPos[pos]=tempNumPos[pos];
            pos++;
        }
    }

    public static void main(String[] args) {
        CountSmaller countSmaller=new CountSmaller();
        System.out.println(countSmaller.countSmaller(new int[]{5,2,6,1,4,3}));
    }
}
