package BitRelsted;

public class ConvertInteger {
    /**
     * 05.06 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
     * <p>
     * 示例1:
     * <p>
     * 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
     * 输出：2
     * <p>
     * 826966453
     * -729934991
     * 14
     */

    public static void main(String[] args) {
        System.out.println(convertInteger(826966453, -729934991));
    }

    public static int convertInteger(int A, int B) {
        int c = A ^ B;
        int cnt = 0;
        while (c != 0) {
            c = c & (c - 1);  //去掉最右边位的1
            cnt++;
        }
        return cnt;
    }
}
