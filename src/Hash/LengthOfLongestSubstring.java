package Hash;

import java.util.HashMap;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb "));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;
        if (s.length() <= 1)
            return s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int[] dp = new int[s.length()];
        int maxLen = 1;
        dp[0] = 1;
        map.put(s.charAt(0), 0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                int prePos = map.get(c);
                dp[i] = i - prePos > dp[i - 1] ? dp[i - 1] + 1 : i - prePos;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
            map.put(c, i);
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }
}
