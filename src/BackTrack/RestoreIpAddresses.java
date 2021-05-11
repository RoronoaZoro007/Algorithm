package BackTrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 93、复原IP地址
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 */
public class RestoreIpAddresses {

    public static void main(String[] args) {
        RestoreIpAddresses restoreIpAddresses=new RestoreIpAddresses();
        System.out.println(restoreIpAddresses.restoreIpAddresses("101023"));
    }

    private List<String> result;

    public List<String> restoreIpAddresses(String s) {
        result = new ArrayList<>();
        if (s == null || s.length() < 4)
            return result;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) < '0' || s.charAt(i) > '9')
                return result;
        }
        backtrack(s,1,0,new LinkedList<>());
        return result;
    }

    private void backtrack(String s, int partNum, int startPos, LinkedList<String> temp) {
        if (partNum == 4) {
            if (startPos >= s.length() || s.length() - startPos > 3) {
                return;
            }
            if (isIP(s, startPos, s.length())) {
                StringBuilder sb = new StringBuilder();
                for (String a : temp) {
                    sb.append(a).append(".");
                }
                sb.append(s.substring(startPos));
                result.add(sb.toString());
            }
            return;
        }
        for (int i = startPos; i < s.length(); i++) {
            if(i-startPos>=3)
                break;
            if(isIP(s,startPos,i+1)){
                temp.add(s.substring(startPos,i+1));
                backtrack(s,partNum+1,i+1,temp);
                temp.removeLast();
            }
        }
    }

    private boolean isIP(String s, int startPos, int endPos) {
        String sub=s.substring(startPos,endPos);
        int val=Integer.parseInt(sub);
        return val >= 0 && val <= 255 && String.valueOf(val).equals(sub);
    }
}
