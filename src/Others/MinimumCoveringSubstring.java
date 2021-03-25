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
    Map<Character, Integer> mapCnt = new HashMap<>();
    Map<Character, Integer> mapRealCnt = new HashMap<>();

    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            mapCnt.put(c, mapCnt.getOrDefault(c, 0) + 1);
        }
        int posL = 0;
        int sLen = s.length();
        int nowPos = 0;
        int resultLen = Integer.MAX_VALUE;
        int resultL = -1;
        int resultR = -1;
        while (nowPos < sLen) {
            char c = s.charAt(nowPos);
            if (mapCnt.containsKey(c)) {
                mapRealCnt.put(c, mapRealCnt.getOrDefault(c, 0) + 1);
            }
            while (checkIfValid() && posL <= nowPos) {
                if (nowPos - posL + 1 < resultLen) {
                    resultLen = nowPos - posL + 1;
                    resultL = posL;
                    resultR = nowPos;
                }
                char charL = s.charAt(posL);
                if (mapCnt.containsKey(charL)) {
                    mapRealCnt.put(charL, mapRealCnt.getOrDefault(charL, 0) - 1);
                }
                posL++;
            }
            nowPos++;
        }
        if (resultL == -1)
            return "";
        return s.substring(resultL, resultR + 1);
    }

    public boolean checkIfValid() {
        for (Map.Entry<Character, Integer> entry : mapCnt.entrySet()) {
            if (mapRealCnt.getOrDefault(entry.getKey(), 0) < entry.getValue())
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumCoveringSubstring minimumCoveringSubstring = new MinimumCoveringSubstring();
        System.out.println(minimumCoveringSubstring.minWindow("a", "a"));
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
