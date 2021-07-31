package GreedyAlgorithm;

public class IncreasingTriplet {


    /**
     * 334 递增的三元子序列
     * 给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。
     * 如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。
     * 示例 1：
     * 输入：nums = [1,2,3,4,5]
     * 输出：true
     * 解释：任何 i < j < k 的三元组都满足题意
     * 示例 2：
     * 输入：nums = [5,4,3,2,1]
     * 输出：false
     * 解释：不存在满足题意的三元组
     * 示例 3：
     * 输入：nums = [2,1,5,0,4,6]
     * 输出：true
     * 解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet_1(int[] nums) {
        if (nums == null || nums.length <= 2)
            return false;
        int len = nums.length;
        //保存当前位置左侧元素的最小值
        int[] leftMin = new int[len];
        //保存当前位置右侧元素的最大值
        int[] rightMax = new int[len];
        //初始化值，0的左边没有比其更大的元素，len-1的右侧没有比其更小的元素
        leftMin[0] = Integer.MAX_VALUE;
        rightMax[len - 1] = Integer.MIN_VALUE;
        for (int i = 1; i < len; i++) {
            leftMin[i] = Math.min(leftMin[i - 1], nums[i - 1]);
        }
        for (int i = len - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i + 1]);
            //如果符合条件则直接返回true
            if (leftMin[i] < nums[i] && nums[i] < rightMax[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length <= 2)
            return false;
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }
}
