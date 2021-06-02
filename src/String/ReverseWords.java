package String;

/**
 * 151. 翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 说明：
 * 无空格字符构成一个 单词 。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 * 示例 1：
 * 输入："the sky is blue"
 * 输出："blue is sky the"
 * 示例 2：
 * 输入："  hello world!  "
 * 输出："world! hello"
 * 解释：输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 */
public class ReverseWords {

    public static void main(String[] args) {
        ReverseWords reverseWords=new ReverseWords();
        System.out.println("["+reverseWords.reverseWords("   ")+"]");
    }

    public String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        if(s==null||s.length()<=0)
            return "";
        int endLeft=s.length()-1;
        int endRight=s.length()-1;
        while(endLeft>=0&&endRight>=0){
            while (endRight>=0&&s.charAt(endRight)==' '){
                endRight--;
            }
            endLeft=endRight;
            while (endLeft>=0&&s.charAt(endLeft)!=' '){
                endLeft--;
            }
            if(endLeft!=endRight){
                sb.append(s.substring(endLeft+1,endRight+1)).append(" ");
            }
            endRight=endLeft;
        }
        if(sb.length()>0)
            sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
