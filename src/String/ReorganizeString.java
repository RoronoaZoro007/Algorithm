package String;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {


    /**
     * 767 重构字符串
     * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
     * 若可行，输出任意可行的结果。若不可行，返回空字符串。
     * 示例 1:
     * 输入: S = "aab"
     * 输出: "aba"
     * 示例 2:
     * 输入: S = "aaab"
     * 输出: ""
     * 注意:
     * S 只包含小写字母并且长度在[1, 500]区间内。
     *
     * @param s
     * @return
     */
    public String reorganizeString(String s) {
        if (s == null || s.length() <= 1)
            return s;
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            freqMap.put(c,freqMap.getOrDefault(c,0)+1);
        }
        PriorityQueue<Character> priorityQueue=new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return freqMap.getOrDefault(o2,0)-freqMap.getOrDefault(o1,0);
            }
        });
        for(Map.Entry<Character,Integer> entry:freqMap.entrySet()){
            priorityQueue.add(entry.getKey());
        }
        StringBuilder sb=new StringBuilder();
        while (priorityQueue.size()>1){
            char c1=priorityQueue.poll();
            char c2=priorityQueue.poll();
            sb.append(c1);
            sb.append(c2);
            if(freqMap.get(c1)>1){
                freqMap.put(c1,freqMap.get(c1)-1);
                priorityQueue.add(c1);
            }
            if(freqMap.get(c2)>1){
                freqMap.put(c2,freqMap.get(c2)-1);
                priorityQueue.add(c2);
            }
        }
        if(priorityQueue.size()==1){
            char c=priorityQueue.poll();
            if(freqMap.get(c)>1)
                return "";
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReorganizeString reorganizeString=new ReorganizeString();
        System.out.println(reorganizeString.reorganizeString("aaab"));
    }
}
