package Hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * 763 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *  
 * <p>
 * 提示：
 * <p>
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        if (s == null)
            return result;
        if (s.length() <= 1) {
            result.add(s.length());
            return result;
        }
        //保存每个元素在字符串中出现的所有pos
        HashMap<Character, LinkedList<Integer>> positionMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            LinkedList<Integer> positionList = positionMap.getOrDefault(s.charAt(i), new LinkedList<>());
            positionList.add(i);
            positionMap.put(s.charAt(i), positionList);
        }
        for (int i = 0; i < s.length(); i++) {
            //最小长度就是i到i位置元素所在的最远pos的距离
            int maxPos = positionMap.get(s.charAt(i)).peekLast();
            //从i+1～maxPos-1之间遍历，看下会不会都在上述的区间里，如果超过了，需要更新该最小长度下的最右位置
            int nowPos = i + 1;
            while (nowPos < maxPos && maxPos < s.length() - 1) {
                int tempPos = positionMap.get(s.charAt(nowPos)).peekLast();
                //更新最远距离
                maxPos = Math.max(tempPos, maxPos);
                nowPos++;
            }
            result.add(maxPos - i + 1);
            //更新i的位置
            i = maxPos;
        }
        return result;
    }

    public static void main(String[] args) {
        PartitionLabels partitionLabels=new PartitionLabels();
        System.out.println(partitionLabels.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
