package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class LongestConsecutive {

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length <= 0)
            return 0;
        Arrays.sort(nums);
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int maxVal = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                dp[i] = dp[i - 1] + 1;
                maxVal = Math.max(maxVal, dp[i]);
            } else if (nums[i] == nums[i - 1]) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = 1;
            }
        }
        return maxVal;
    }

    public int longestConsecutive_1(int[] nums) {
        if (nums == null || nums.length <= 0)
            return 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : nums)
            hashSet.add(i);
        int maxLen = 1;
        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            int val = iterator.next();
            int len = 1;
            if (!hashSet.contains(val - 1)) {
                while (hashSet.contains(val + 1)) {
                    val++;
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            } else {
                //do nothing
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestConsecutive longestConsecutive=new LongestConsecutive();
        System.out.println(longestConsecutive.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }

}
