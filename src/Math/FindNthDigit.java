package Math;

/**
 * 400 第N位数
 * 在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 位数字。
 * 注意：n 是正数且在 32 位整数范围内（n < 231）。
 * 示例 1：
 * 输入：3
 * 输出：3
 * 示例 2：
 * 输入：11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 */
public class FindNthDigit {

    //1234567891011121314151617181920
    //1 - [1,9]             9
    //2 - [10,99]          90
    //3 - [100,999]       900
    //4 - [1000,9999]    9000
    public int findNthDigit(int n) {
        if (n <= 9)
            return n;
        long length = 0;
        int cnt = 9;
        int digit = 1;
        for (; length + (long) cnt * digit < n; digit++) {
            length += (long) cnt * digit;
            cnt *= 10;
        }
        //digit就是找到的位数，就是说实际在几位数中
        //num就是在哪个数字中
        //(n - length - 1) / digit表示在这digit长的位数中排名第几，用起始的10^（digit-1）加上就是找到的这个位数
        long num = (long)Math.pow(10, digit - 1) + (n - length - 1) / digit;
        //找到在num中对应的位置，由于这个长度的位数，都是digit的长度
        //用查找的长度n减去前面位数的总和length，再模上digit，就可以得到位数了
        int index = (int)(n - length - 1) % digit;
        return String.valueOf(num).charAt(index) - '0';
    }

    public static void main(String[] args) {
        FindNthDigit findNthDigit = new FindNthDigit();
        System.out.println(findNthDigit.findNthDigit(1000000000));
    }
}
