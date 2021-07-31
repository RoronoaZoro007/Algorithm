package GreedyAlgorithm;

public class JumpGame {

    /**
     * 55 跳跃游戏1
     * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 判断你是否能够到达最后一个下标。
     * 示例 1：
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * 示例 2：
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int maxPos = 0;
        for (int i = 0; i < len; i++) {
            if (i <= maxPos) {
                maxPos = Math.max(maxPos, i + nums[i]);
                if (maxPos >= len - 1)
                    return true;
            }
        }
        return false;
    }


    public boolean canJump_1(int[] nums) {
        int maxPos = 0;
        while (maxPos < nums.length - 1 && nums[maxPos] != 0) {
            int len = nums[maxPos];
            if (maxPos + nums[maxPos] >= nums.length - 1) {
                return true;
            }
            int tempMaxPos = maxPos;
            int tempPos = maxPos;
            //每次选当前这个位置能够走的位置范围内，选择走这个pos对应能够走的位置最远的pos作为下一跳
            for (int i = maxPos + 1; i <= maxPos + len; i++) {
                if (i + nums[i] > tempMaxPos) {
                    tempMaxPos = i + nums[i];
                    tempPos = i;
                }
            }
            maxPos = tempPos;
        }
        if (maxPos >= nums.length - 1)
            return true;
        return false;
    }

    /**
     * 45 跳跃游戏2
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * 假设你总是可以到达数组的最后一个位置。
     * 示例 1:
     * 输入: [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
     * 示例 2:
     * 输入: [2,3,0,1,4]
     * 输出: 2
     * 提示:
     * 1 <= nums.length <= 1000
     * 0 <= nums[i] <= 105
     *
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int len = nums.length;
        int maxPos = 0;
        int nowPos = 0;
        int end = 0;
        int steps = 0;
        while (end < len - 1) {
            maxPos = Math.max(maxPos, nowPos + nums[nowPos]);
            //end表示上一个最大pos能够走的距离的范围
            //nowPos==end表示当前位置已经走到了上一个最大pos能够走的最大的范围了，这时候需要更新我们走到哪个位置好
            //更新走到的新的位置能够走的最大的距离
            if (nowPos == end) {
                steps++;
                end = maxPos;
            }
            nowPos++;
        }
        return steps;
    }

    public static void main(String[] args) {
        JumpGame jumpGame = new JumpGame();
        System.out.println(jumpGame.canJump(new int[]{3, 2, 1, 0, 0}));
    }
}
