package Hash;

import java.util.*;

public class GroupAnagrams {

    /**
     * 49. 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     * <p>
     * 示例:
     * <p>
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> tempMap = new HashMap<>();
        for (String s : strs) {
            char[] temp = s.toCharArray();
            Arrays.sort(temp);
            String str = String.valueOf(temp);
            List<String> strList = tempMap.getOrDefault(str, new ArrayList<>());
            strList.add(s);
            tempMap.put(str, strList);
        }
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : tempMap.entrySet()) {
            result.add(new ArrayList<>(entry.getValue()));
        }
        return result;
    }
}
