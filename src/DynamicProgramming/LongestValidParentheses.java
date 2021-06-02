package DynamicProgramming;

public class LongestValidParentheses {

    public static void main(String[] args) {
        LongestValidParentheses longestValidParentheses=new LongestValidParentheses();
        System.out.println(longestValidParentheses.longestValidParentheses(")()"));
    }

    public int longestValidParentheses(String s) {
        if(s==null||s.length()<=1)
            return 0;
        int len=s.length();
        int[] count=new int[len];
        count[0]=0;
        int maxLen=0;
        for(int i=1;i< len;i++){
            if(s.charAt(i)=='('){
                count[i]=0;
            }else{//s.charAt(i)=')'
                if(s.charAt(i-1)=='('){
                    count[i]=(i-2>=0?count[i-2]:0)+2;
                }else{//s.charAt(i-1)==')'
                    int prePos=i-1-count[i-1]; //前一个）匹配的最左的（的前一个位置
                    if(prePos>=0&&s.charAt(prePos)=='('){
                        count[i]=count[i-1]+2+((prePos-1)>=0?count[prePos-1]:0);
                    }else{
                        count[i]=0;
                    }
                }
            }
            maxLen=Math.max(maxLen,count[i]);
        }
        return maxLen;
    }
}
