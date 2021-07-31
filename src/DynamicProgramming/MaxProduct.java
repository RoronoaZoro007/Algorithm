package DynamicProgramming;

import java.util.Arrays;

public class MaxProduct {

    /**
     * 152 乘积最大子数组
     * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
     * 示例 1:
     * 输入: [2,3,-2,4]
     * 输出: 6
     * 解释: 子数组 [2,3] 有最大乘积 6。
     * 示例 2:
     * 输入: [-2,0,-1]
     * 输出: 0
     * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if(nums==null|| nums.length<=0){
            return 0;
        }
        int len=nums.length;
        //以当前位置为结束的子数组的最大值
        int[] maxDp=new int[len];
        //以当前位置为结束的子数组的最小值
        int[] minDp=new int[len];
        maxDp[0]=nums[0];
        minDp[0]=nums[0];
        int maxVal=nums[0];
        for (int i = 1; i < len; i++) {
            //当当前这个数为正的时，当前值*maxDp（i-1）可能是最大值
            //当当前这个数为负数时，当前值*minDP（i-1）可能是最大值
            //或者之前的最大值是0，那么其自身才是最大值
            maxDp[i]=Math.max(nums[i]*maxDp[i-1],Math.max(nums[i]*minDp[i-1],nums[i]));
            minDp[i]=Math.min(nums[i]*maxDp[i-1],Math.min(nums[i]*minDp[i-1],nums[i]));
            maxVal=Math.max(maxVal,maxDp[i]);
        }
        return maxVal;
    }
}
