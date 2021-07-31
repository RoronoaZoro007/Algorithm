package BitRelated;

import java.util.Arrays;

public class SingleNumber {

    /**
     * 260 只出现一次的数字
     * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
     * 进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
     * 示例 1：
     * 输入：nums = [1,2,1,3,2,5]
     * 输出：[3,5]
     * 解释：[5, 3] 也是有效的答案。
     * 示例 2：
     * 输入：nums = [-1,0]
     * 输出：[-1,0]
     * 示例 3：
     * 输入：nums = [0,1]
     * 输出：[1,0]
     * @param nums
     * @return
     */
    public int[] singleNumber(int[] nums) {
        if(nums==null||nums.length<=1){
            return new int[0];
        }
        int temp=nums[0];
        for (int i = 1; i < nums.length; i++) {
            temp=temp^nums[i];
        }
        int len=1;
        //找到异或值为1的位
        //通过异或值位1的位来对数组进行划分，该位为1的是一组，该位不为1的是一组
        while(temp!=0){
            if(temp%2!=0){
                break;
            }
            temp=temp>>1;
            len=len<<1;
        }
        int val1=0;
        int val2=0;
        //按照分组进行异或，就可以得到最终的值
        for (int i = 0; i < nums.length; i++) {
            if((nums[i]&len)!=0){
                val1=val1^nums[i];
            }else{
                val2=val2^nums[i];
            }
        }
        return new int[]{val1,val2};
    }

    public static void main(String[] args) {
        SingleNumber singleNumber=new SingleNumber();
        System.out.println(Arrays.toString(singleNumber.singleNumber(new int[]{1,2,1,3,2,5})));
    }
}
