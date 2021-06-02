package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    /**
     * 38.字符串的排列
     * 输入一个字符串，打印出该字符串中字符的所有排列。
     * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
     * 示例:
     * 输入：s = "abc"
     * 输出：["abc","acb","bac","bca","cab","cba"]
     * 限制：
     * 1 <= s 的长度 <= 8
     *
     * @param s
     * @return
     */
    public String[] permutation(String s) {
        List<String> out = new ArrayList<>();
        if (s == null)
            return new String[0];
        backTrack(out,new StringBuilder(s),0);
        return out.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Permutation permutation=new Permutation();
        System.out.println(Arrays.toString(permutation.permutation("abbc")));
    }

    private void backTrack(List<String> out, StringBuilder sb, int pos) {
        if (pos == sb.length()) {
            out.add(sb.toString());
            return;
        }
        for (int i = pos; i < sb.length(); i++) {
            if(canSwap(sb,pos,i)){
                swapStringBuilder(sb,pos,i);
                backTrack(out,sb,pos+1);
                swapStringBuilder(sb,pos,i);
            }
        }
    }

    private boolean canSwap(StringBuilder sb,int start,int end){
        for (int i = start; i < end; i++) {
            if(sb.charAt(i)==sb.charAt(end)){
                return false;
            }
        }
        return true;
    }

    private void swapStringBuilder(StringBuilder sb,int left,int right){
        char c=sb.charAt(left);
        sb.setCharAt(left,sb.charAt(right));
        sb.setCharAt(right,c);
    }
}
