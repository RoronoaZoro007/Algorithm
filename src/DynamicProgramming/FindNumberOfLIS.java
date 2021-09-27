package DynamicProgramming;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 673 最长递增子序列的个数
 * 给定一个未排序的整数数组，找到最长递增子序列的个数。
 * 示例 1:
 * 输入: [1,3,5,4,7]
 * 输出: 2
 * 解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
 * 示例 2:
 * 输入: [2,2,2,2,2]
 * 输出: 5
 * 解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
 * 注意: 给定的数组长度不超过 2000 并且结果一定是32位有符号整数。
 */
public class FindNumberOfLIS {


    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length <= 0)
            return 0;
        //以当前位置为末尾元素的最长子序列的最大长度
        int[] dpLength = new int[nums.length];
        //以当前位置为末尾元素的最长子序列的cnt
        int[] dpCount = new int[nums.length];
        dpLength[0] = 1;
        dpCount[0] = 1;
        int maxLen = 1;
        for (int i = 1; i < nums.length; i++) {
            dpLength[i] = 1;
            dpCount[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (dpLength[j] + 1 > dpLength[i]) {
                        dpLength[i] = dpLength[j] + 1;
                        dpCount[i] = dpCount[j];
                    } else if (dpLength[j] + 1 == dpLength[i]) {
                        //如果dp[j]+1=dp[i]，长度相等，那么说明还有个另外的序列长度符合的子序列，加上这个子序列的cnt
                        dpCount[i] += dpCount[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, dpLength[i]);
        }
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (dpLength[i] == maxLen) {
                cnt += dpCount[i];
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        FindNumberOfLIS findNumberOfLIS = new FindNumberOfLIS();
        System.out.println(findNumberOfLIS.findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(findNumberOfLIS.findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));

        List<Integer> queue=new LinkedList<>();

    }
}
