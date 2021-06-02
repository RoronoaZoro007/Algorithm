package BinarySearch;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 进阶：
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 * 示例 1：
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 */
public class SearchRange {

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        System.out.println(Arrays.toString(searchRange.searchRange(new int[]{7, 7, 7}, 7)));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        Arrays.fill(result, -1);
        if (nums == null || nums.length <= 0 || nums[0] > target || nums[nums.length - 1] < target)
            return result;
        int start = 0;
        int end = nums.length - 1;
        int mid;
        //找到第一个>=target的数
        while (start < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                //left search
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        if (nums[start] != target) {
            return result;
        }
        result[0] = start;
        end = nums.length - 1;
        //找到第一个>target的元素的位置,当后续所有的值都和target相同时可能这个位置不存在，只能找到最后一个target出现的位置
        while (start < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] <= target) {
                //right search
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        //判断找到的元素是不是真的比target大，因为可能后续所有的值都等于target，此时只能找到最后一个位置
        if (nums[start] > target && start - 1 >= 0) {
            result[1] = start - 1;
        } else {
            result[1] = start;
        }
        return result;
    }
}
