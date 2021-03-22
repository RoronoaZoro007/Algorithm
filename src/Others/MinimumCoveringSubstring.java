package Others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class MinimumCoveringSubstring {

    /**
     * 76.最小覆盖子串
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
     * 示例 1：
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * <p>
     * 示例 2：
     * 输入：s = "a", t = "a"
     * 输出："a"
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> mapt = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            mapt.put(c, mapt.getOrDefault(c, 0) + 1);
        }
        return "";
    }

    public void test() {
        List<POJO1> pojo1s = new ArrayList<>();
        Map<Integer, POJO1> collect1 = pojo1s.stream().collect(Collectors.toMap(POJO1::getA1, pojo1 -> pojo1));
        List<POJO2> pojo2s = new ArrayList<>();
        Map<POJO1, POJO2> collect2 = pojo2s.stream().collect(Collectors.toMap(pojo2 -> collect1.get(pojo2.getA2() + pojo2.getB2()), pojo2 -> pojo2));
        List<POJO3> pojo3s = pojo2s.stream().map(pojo2 -> this.getresult(collect1.get(pojo2.getA2() + pojo2.getB2()), pojo2)).collect(Collectors.toList());
        Map<Integer, List<POJO3>> collect3 = pojo3s.stream().collect(Collectors.toMap(pojo3 -> pojo3.getC3(), pojo3 -> new ArrayList<>(), (p1, p2) -> p1));
        pojo3s.forEach(pojo3 -> {
            collect3.get(pojo3.getC3()).add(pojo3);
        });
        Map<POJO1, List<POJO3>> collect4 = pojo1s.stream().collect(Collectors.toMap(pojo1 -> pojo1, pojo1 -> {
            List<POJO3> pojo3s1 = new ArrayList<>();
            POJO2 pojo2 = collect2.get(pojo1);
            if (pojo2.getB2() != 0) {
                pojo3s1.addAll(collect3.get(pojo2.getB2()));
            }
            if (pojo2.getC2() != 0) {
                pojo3s1.addAll(collect3.get(pojo2.getC2()));
            }
            return pojo3s1;
        }));
    }

    public POJO3 getresult(POJO1 pojo1, POJO2 pojo2) {
        return new POJO3();
    }
}
