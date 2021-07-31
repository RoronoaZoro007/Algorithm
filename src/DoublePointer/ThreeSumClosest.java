package DoublePointer;

import java.util.Arrays;

public class ThreeSumClosest {


    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length <= 2) {
            return Integer.MIN_VALUE;
        }
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            int rest = target - nums[i];
            while (start < end) {
                result = Math.abs(target - result) > Math.abs(target - nums[i] - nums[start] - nums[end])
                        ? (nums[i] + nums[start] + nums[end]) : result;
                if ((nums[start] + nums[end]) > rest) {
                    end--;
                } else if ((nums[start] + nums[end]) < rest) {
                    start++;
                } else {
                    return target;
                }
            }
        }
        return result;
    }
}
