package Stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class NextGreaterElement {

    /**
     * 下一个更大元素 1
     * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
     * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
     * 示例 1:
     * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
     * 输出: [-1,3,-1]
     * 解释:
     * 对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
     * 对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
     * 对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
     * 示例 2:
     * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
     * 输出: [3,-1]
     * 解释:
     *     对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
     * 对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
     * 提示：
     * 1 <= nums1.length <= nums2.length <= 1000
     * 0 <= nums1[i], nums2[i] <= 104
     * nums1和nums2中所有整数 互不相同
     * nums1 中的所有整数同样出现在 nums2 中
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //保存的是一个数组元素的递减队列
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> greaterMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            //每当当前元素比递减栈中的头大时，说明有更大的元素，然后将其对应关系存储在一个hashMap中
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                greaterMap.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            //map中不存在的说明是没有更大的元素了，直接设置为-1
            result[i] = greaterMap.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    public int[] nextGreaterElements_2(int[] nums) {
        if(nums==null)
            return new int[0];
        Deque<Integer> nextGreaterPos = new LinkedList<>();
        int len = nums.length;
        for (int i = len - 1; i >= 0; i--) {
            while (!nextGreaterPos.isEmpty() && nums[i] > nums[nextGreaterPos.peekLast()%len]) {
                nextGreaterPos.pollLast();
            }
            nextGreaterPos.add((len - 1) + i);
        }
        int[] result=new int[len];
        for (int i = len-1; i >=0 ; i--) {
            while(!nextGreaterPos.isEmpty()&&(nextGreaterPos.peekFirst()-i)>=len){
                nextGreaterPos.pollFirst();
            }
            while (!nextGreaterPos.isEmpty()&&nums[nextGreaterPos.peekLast()%len]<=nums[i]){
                nextGreaterPos.pollLast();
            }
            if(nextGreaterPos.isEmpty()){
                result[i]=-1;
            }else{
                result[i]=nums[nextGreaterPos.peekLast()%len];
            }
            nextGreaterPos.add(i);
        }
        return result;
    }
}
