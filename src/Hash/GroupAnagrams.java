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
        for (int i = 0; i < strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String str = String.valueOf(temp);
            if (tempMap.containsKey(str)) {
                tempMap.get(str).add(strs[i]);
            } else {
                List<String> strList = new ArrayList<>();
                strList.add(strs[i]);
                tempMap.put(str, strList);
            }
        }
        List<List<String>> result=new ArrayList<>();
        Iterator iterator=tempMap.keySet().iterator();
        while (iterator.hasNext()){
            result.add(tempMap.get(iterator.next()));
        }
        return result;
    }
}
