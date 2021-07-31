package GreedyAlgorithm;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FindMaximumXOR {

    /**
     * 421 数组中两个数的最大异或值
     * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
     * 进阶：你可以在 O(n) 的时间解决这个问题吗？
     * 示例 1：
     * 输入：nums = [3,10,5,25,2,8]
     * 输出：28
     * 解释：最大运算结果是 5 XOR 25 = 28.
     * 示例 2：
     * 输入：nums = [0]
     * 输出：0
     * 示例 3：
     * 输入：nums = [2,4]
     * 输出：6
     * 提示：
     * 1 <= nums.length <= 2 * 104
     * 0 <= nums[i] <= 231 - 1
     *
     * @param nums
     * @return
     */
    public int findMaximumXOR(int[] nums) {
        //利用性质a^b=c -> a^c=b;  b^c=a
        //可以每次假设当前这个位为1，判断假设的值^掩码后的值，是否在数组中存在对应的，存在则说明当前这一位是可以为1的
        if (nums == null || nums.length <= 1) {
            return 0;
        }
        int res = 0;
        int mask = 0;
        for (int i = 30; i >= 0; i--) {
            mask = mask | (1 << i);
            Set<Integer> prefix = new HashSet<>();
            for (int num : nums) {
                prefix.add(num & mask);
            }
            //之前得到的前面位数的结果+当前这位为1
            int temp = res | (1 << i);
            for (Integer tempPrefix : prefix) {
                //存在结果，直接下一位判断
                if (prefix.contains(tempPrefix ^ temp)) {
                    res = temp;
                    break;
                }
            }
        }
        return res;
    }
}
