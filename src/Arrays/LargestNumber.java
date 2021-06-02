package Arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 179、最大数
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 * 示例 2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 示例 3：
 * 输入：nums = [1]
 * 输出："1"
 */
public class LargestNumber {

    public static void main(String[] args) {
        LargestNumber largestNumber=new LargestNumber();
        System.out.println(largestNumber.largestNumber(new int[]{34323,3432}));
    }


    public String largestNumber(int[] nums) {
        Integer[] temp=new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[i]=nums[i];
        }
        Arrays.sort(temp, (o1, o2) -> {
            String temp1=o1.toString();
            String temp2=o2.toString();
            return compareString(temp1+temp2,temp2+temp1);
        });
        StringBuilder sb=new StringBuilder();
        for (int i = nums.length-1; i >=0; i--) {
            sb.append(temp[i]);
        }
        if(sb.charAt(0)=='0')
            return "0";
        return sb.toString();
    }

    private int compareString(String str1,String str2){
        int pos=0;
        while (pos<str1.length()){
            int val=str1.charAt(pos)-str2.charAt(pos);
            if(val!=0)
                return val;
            pos++;
        }
        return 0;
    }
}
