package BinarySearch;

/**
 * 154 寻找旋转排序数组中的最小值
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,4,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,4]
 * 若旋转 7 次，则可以得到 [0,1,4,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * 给你一个可能存在 重复 元素值的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * 示例 1：
 * 输入：nums = [1,3,5]
 * 输出：1
 * 示例 2：
 * 输入：nums = [2,2,2,0,1]
 * 输出：0
 * 提示：
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 * 进阶：
 * 这道题是 寻找旋转排序数组中的最小值 的延伸题目。
 * 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？
 */
public class FindMin {

    public int findMin(int[] nums) {
        if (nums == null || nums.length <= 0)
            return Integer.MIN_VALUE;
        int start = 0;
        int end = nums.length - 1;
        while (end >= 0 && nums[end] == nums[start]) {
            end--;
        }
        if (end < 0||nums[end]>=nums[start])
            return nums[start];
        while (start < end) {
            int mid = start + (end - start) / 2;
            //例如 2 2 2 0 1，存在mid=2，那么就在右边找，如果小于2，就在包含其自身的左边找
            if(nums[mid]<nums[0]){
                end=mid;
            }else{
                start=mid+1;
            }
        }
        return nums[start];
    }
}
