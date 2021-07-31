package Stack;

import java.util.HashSet;
import java.util.Stack;

public class Find132pattern {

    /**
     * 456. 132模式
     * 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。
     * 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。
     * 示例 1：
     * 输入：nums = [1,2,3,4]
     * 输出：false
     * 解释：序列中不存在 132 模式的子序列。
     * 示例 2：
     * 输入：nums = [3,1,4,2]
     * 输出：true
     * 解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        if(nums==null||nums.length<=2){
            return false;
        }
        //从尾到头的递减栈
        Stack<Integer> stack=new Stack<>();
        //用来保存ijk中的k的值
        int preMax=Integer.MIN_VALUE;
        for (int i = nums.length-1; i >=0 ; i--) {
            //preMax>nums[i]的话，表示preMax必然出栈了，当前栈顶的元素一定大于preMax，也就是j>k的，又有k>i,那么符合条件
            if(preMax>nums[i])
                return true;
            while (!stack.isEmpty()&&stack.peek()<nums[i]){
                preMax=Math.max(preMax,stack.pop());
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        HashSet<Integer> set=new HashSet<>();

    }
}
