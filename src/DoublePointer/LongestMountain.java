package DoublePointer;

/**
 * 845 数组中的最长山脉
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 * 如果不含有 “山脉” 则返回 0。
 * 示例 1：
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * 示例 2：
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 * 提示：
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 */
public class LongestMountain {


    public int longestMountain(int[] arr) {
        if (arr == null || arr.length <= 0)
            return 0;
        int len = arr.length;
        //代表以当前位置为结束的左侧升序序列的最大长度（不含当前节点）
        int[] leftMinLen = new int[len];
        //代表以当前位置为结束的右侧降序序列的最大长度（不含当前节点）
        int[] rightMinLen = new int[len];
        for (int i = 1; i < len; i++) {
            if (arr[i] > arr[i - 1]) {
                leftMinLen[i] = leftMinLen[i - 1] + 1;
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                rightMinLen[i] = rightMinLen[i + 1] + 1;
            }
        }
        int maxLen = 0;
        for (int i = 1; i < len - 1; i++) {
            if (leftMinLen[i] > 0 && rightMinLen[i] > 0) {
                maxLen = Math.max(maxLen, leftMinLen[i] + rightMinLen[i] + 1);
            }
        }
        return maxLen;
    }
}
