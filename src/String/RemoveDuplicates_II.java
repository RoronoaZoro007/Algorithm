package String;

import java.util.Arrays;

public class RemoveDuplicates_II {

    /**
     * 80 删除有序数组中的重复项II
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * 说明：
     * 为什么返回数值是整数，但输出的答案是数组呢？
     * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     * 你可以想象内部操作如下:
     * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
     * int len = removeDuplicates(nums);
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length <= 2)
            return nums == null ? 0 : nums.length;
        int startPos=0;
        int nowPos=0;
        int prePos=0;
        int len=0;
        while(nowPos<nums.length){
            if(nums[nowPos]!=nums[startPos]){
                int cnt= Math.min((nowPos - startPos), 2);
                len+=cnt;
                while (cnt>0){
                    nums[prePos++]=nums[startPos];
                    cnt--;
                }
                startPos=nowPos;
            }
            nowPos++;
        }
        int cnt= Math.min((nowPos - startPos), 2);
        len+=cnt;
        while (cnt>0){
            nums[prePos++]=nums[startPos];
            cnt--;
        }
        System.out.println(Arrays.toString(nums));
        return len;
    }

    public static void main(String[] args) {
        RemoveDuplicates_II removeDuplicates_ii=new RemoveDuplicates_II();
        System.out.println(removeDuplicates_ii.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3}));
    }
}
