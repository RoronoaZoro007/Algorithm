package Arrays;

public class ReversePairs {

    /**
     * offer：数组中的逆序对
     * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
     * 示例 1:
     * 输入: [7,5,6,4]
     * 输出: 5
     *
     * @param nums
     * @return
     */

    //降序归并
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;
        return merge(nums, new int[nums.length], 0, nums.length - 1);
    }

    private int merge(int[] nums, int[] temp, int start, int end) {
        if (start >= end)
            return 0;
        int mid = start + (end - start) / 2;
        int left = merge(nums, temp, start, mid);
        int right = merge(nums, temp, mid + 1, end);
        int nowVal = left + right;
        int leftStart = start;
        int rightStart = mid + 1;
        int nowPos = start;
        while (leftStart <= mid && rightStart <= end) {
            if (nums[leftStart] > nums[rightStart]) {
                nowVal += (end - rightStart + 1);
                temp[nowPos++] = nums[leftStart++];
            } else {
                temp[nowPos++] = nums[rightStart++];
            }
        }
        while (leftStart <= mid) {
            temp[nowPos++] = nums[leftStart++];
        }
        while (rightStart <= end) {
            temp[nowPos++] = nums[rightStart++];
        }
        nowPos = start;
        while (nowPos <= end) {
            nums[nowPos] = temp[nowPos];
            nowPos++;
        }
        return nowVal;
    }

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        System.out.println(reversePairs.reversePairs(new int[]{7, 5, 6, 4}));
        StringBuilder sb=new StringBuilder();
    }
}
