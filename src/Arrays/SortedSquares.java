package Arrays;

public class SortedSquares {

    public int[] sortedSquares(int[] nums) {
        int mid = findMid(nums, 0, nums.length - 1);
        int[] result = new int[nums.length];
        int leftStart = mid - 1;
        int rightStart = mid;
        int pos = 0;
        while (leftStart >= 0 && rightStart < nums.length) {
            if (nums[rightStart] * nums[rightStart] < nums[leftStart] * nums[leftStart]) {
                result[pos++] = nums[rightStart] * nums[rightStart];
                rightStart++;
            } else {
                result[pos++] = nums[leftStart] * nums[leftStart];
                leftStart--;
            }
        }
        while (leftStart >= 0) {
            result[pos++] = nums[leftStart] * nums[leftStart];
            leftStart--;
        }
        while (rightStart < nums.length) {
            result[pos++] = nums[rightStart] * nums[rightStart];
            rightStart++;
        }
        return result;
    }

    //找到大于等于0的最小值pos
    private int findMid(int[] nums, int start, int end) {
        int mid;
        while (start < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == 0) {
                return mid;
            } else if (nums[mid] < 0) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
}
