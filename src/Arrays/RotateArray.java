package Arrays;

import java.util.Arrays;

public class RotateArray {

    /**
     * 189、旋转数组
     * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 进阶：
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
     * 示例 1:
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     *
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        for (int i = 1; i <= k; i++) {
            int tempPos = nums.length - i;
            int temp = nums[tempPos];
            while (tempPos - k >= 0) {
                nums[tempPos] = nums[tempPos - k];
                tempPos = tempPos - k;
            }
            nums[tempPos] = temp;
        }
    }

    public void rotate_1(int[] nums, int k) {
        k = k % nums.length;
        reverseArray(nums, 0, nums.length-1);
        reverseArray(nums,0,k-1);
        reverseArray(nums,k,nums.length-1);
    }

    private void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {
        RotateArray rotateArray = new RotateArray();
        int[] temp = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotateArray.rotate(temp, 3);
        System.out.println(Arrays.toString(temp));
    }
}
