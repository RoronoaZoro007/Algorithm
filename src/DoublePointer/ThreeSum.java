package DoublePointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
     * 使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * 注意：答案中不可以包含重复的三元组。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int startPos = i + 1;
            int endPos = nums.length - 1;
            int target = -nums[i];
            while (startPos < endPos) {
                if (nums[startPos] + nums[endPos] == target) {
                    result.add(Arrays.asList(nums[i], nums[startPos], nums[endPos]));
                    while (startPos < endPos && nums[startPos] == nums[startPos + 1])
                        startPos++;
                    startPos++;
                    while (startPos < endPos && nums[endPos] == nums[endPos - 1])
                        endPos--;
                    endPos--;
                } else if (nums[startPos] + nums[endPos] > target) {
                    while (startPos < endPos && nums[endPos] == nums[endPos - 1])
                        endPos--;
                    endPos--;
                } else {
                    while (startPos < endPos && nums[startPos] == nums[startPos + 1])
                        startPos++;
                    startPos++;
                }
            }
        }
        return result;
    }

    /**
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
     * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     * 注意：答案中不可以包含重复的四元组。
     *
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int startPos = j + 1;
                int endPos = nums.length - 1;
                int rest_target = target - nums[i] - nums[j];
                while (startPos < endPos) {
                    if (nums[startPos] + nums[endPos] == rest_target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[startPos], nums[endPos]));
                        while (startPos < endPos && nums[startPos] == nums[startPos + 1])
                            startPos++;
                        startPos++;
                        while (startPos < endPos && nums[endPos] == nums[endPos - 1])
                            endPos--;
                        endPos--;
                    } else if (nums[startPos] + nums[endPos] > rest_target) {
                        while (startPos < endPos && nums[endPos] == nums[endPos - 1])
                            endPos--;
                        endPos--;
                    } else {
                        while (startPos < endPos && nums[startPos] == nums[startPos + 1])
                            startPos++;
                        startPos++;
                    }
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
//        System.out.println(threeSum.threeSum(new int[]{-5, -5, -2, -1, -3, -2, -5, 2, 4, 1, 0, 2, 1, -5, 1, -4}));
        System.out.println(threeSum.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
