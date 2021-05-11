package DynamicProgramming;

import java.util.Arrays;
import java.util.Stack;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length <= 1)
            return nums.length;
        int[] dp = new int[nums.length];
        int maxVal = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            maxVal = Math.max(maxVal, dp[i]);
        }
        return maxVal;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
    public static int mySqrt(int x) {
        if(x<=1)
            return x;
        int left=0;
        int right=x;
        int result=-1;
        int mid=0;
        while(left<=right){
            mid=left+(right-left)/2;
            if((long)mid*mid<=x){
                result=mid;
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return result;
    }
}
