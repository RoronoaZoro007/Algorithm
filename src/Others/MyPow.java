package Others;

public class MyPow {

    /**
     * 50.实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
     * 示例 1：
     * 输入：x = 2.00000, n = 10
     * 输出：1024.00000
     * 示例 2：
     * 输入：x = 2.10000, n = 3
     * 输出：9.26100
     * 示例 3：
     * 输入：x = 2.00000, n = -2
     * 输出：0.25000
     * 解释：2-2 = 1/22 = 1/4 = 0.25
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0)
            return 1.0;
        //由于负数转正会超出int的范围，因此需要先转为long
        long N = n;
        return N > 0 ? getPow(x, N) : 1.0 / getPow(x, -N);
    }

    //tip:类似于x^77的话，77=64+8+4+1，因此可以在每次%2==1的时候将对应的次幂的值加入到结果中去
    private double getPow(double x, long n) {
        if (n == 0)
            return 1.0;
        double result = 1.0;
        double contribution = x;
        while (n > 0) {
            if (n % 2 == 1) {
                result *= contribution;
            }
            contribution *= contribution;
            n = n >> 1;
        }
        return result;
    }
}
