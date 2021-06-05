package String;

import java.util.Arrays;

public class Compress {


    /**
     * 443.压缩字符串
     * 给定一组字符，使用原地算法将其压缩。
     * 压缩后的长度必须始终小于或等于原数组长度。
     * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
     * 在完成原地修改输入数组后，返回数组的新长度。
     * 进阶：
     * 你能否仅使用O(1) 空间解决问题？
     * 示例 1：
     * 输入：
     * ["a","a","b","b","c","c","c"]
     * 输出：
     * 返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
     * 说明：
     * "aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
     * @param chars
     * @return
     */
    public int compress(char[] chars) {
        if(chars==null)
            return 0;
        if(chars.length<=1)
            return chars.length;
        //标识当前应该写入的位置
        int writePos=0;
        //标识当前这个元素开始的位置
        int startPos=0;
        for (int readPos = 0; readPos < chars.length; readPos++) {
            if(readPos+1==chars.length||chars[readPos+1]!=chars[readPos]){
                //将写入位置的初始元素设置为读取的元素
                chars[writePos++]=chars[readPos];
                //如果重复元素的长度大于1，则需要写入长度
                if(readPos>startPos){
                    for(char c:String.valueOf(readPos-startPos+1).toCharArray()){
                        chars[writePos++]=c;
                    }
                }
                //更新下一元素的起始位置
                startPos=readPos+1;
            }
        }
        System.out.println(Arrays.toString(chars));
        return writePos;
    }

    public static void main(String[] args) {
        Compress compress=new Compress();
        System.out.println(compress.compress(new char[]{'a','a','a','b','b','c','d','d'}));
    }
}
