package DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 139 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * <p>
 * 说明：
 * <p>
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 * 示例 2：
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 */
public class WordBreak {

    //i、j范围之间的单词是否能够符合
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null)
            return false;
        HashSet<String> wordSet = new HashSet<>();
        int maxWordLen = 0;
        for (String word : wordDict) {
            wordSet.add(word);
            maxWordLen = Math.max(maxWordLen, word.length());
        }
        if (wordSet.contains(s))
            return true;
        //dp数组，用来表示i，j之间的能否由wordDict组成！
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j < s.length(); j++) {
                //以i为长度的，以j为结束位置的字符串的起始位置
                int startPos = j - i + 1;
                //如果startPos～j位置间的字符串直接就在字典中，那么直接就是1
                //否则，遍历判断是否中间有个分割点，使得分割点前能够符合条件，且分割点后的也能符合条件
                if (wordDict.contains(s.substring(startPos, j + 1))) {
                    dp[startPos][j] = 1;
                } else {
                    for (int k = j - 1; k >= startPos; k--) {
                        if (dp[startPos][k] == 1 && dp[k + 1][j] == 1) {
                            dp[startPos][j] = 1;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][s.length() - 1] == 1;
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        System.out.println(wordBreak.wordBreak("applepenapple", Stream.of("apple", "pen").collect(Collectors.toList())));
    }
}
