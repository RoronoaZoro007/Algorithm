package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubarraySum {

    /**
     * 560 和为k的子数组
     * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
     * 示例 1 :
     * 输入:nums = [1,1,1], k = 2
     * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
     * 说明 :
     * 数组的长度为 [1, 20,000]。
     * 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> sumMap=new HashMap<>();
        int sum=0;
        int out=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            int count=sumMap.getOrDefault(sum,0);
            if(sumMap.containsKey(sum-k)){
                out+=sumMap.get(sum-k);
            }
            if(sum==k)
                out++;
            count++;
            sumMap.put(sum,count);
        }
        return out;
    }

    public static void main(String[] args) {
        SubarraySum subarraySum=new SubarraySum();
        System.out.println(subarraySum.subarraySum(new int[]{1,1,1},2));
    }
}
