package GreedyAlgorithm;

public class CanPlaceFlowers {

    /**
     * 605.假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
     * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？
     * 能则返回True，不能则返回False。
     * 示例 1:
     * 输入: flowerbed = [1,0,0,0,1], n = 1
     * 输出: True
     * 示例 2:
     * 输入: flowerbed = [1,0,0,0,1], n = 2
     * 输出: False
     *
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length <= 0 || n < 0)
            return false;
        int preNo0Len = 1; //前面没有种花的间隔 开始位置和结束额外加1的种花间隔
        int result = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                result += (preNo0Len - 1) / 2;
                preNo0Len = 0;
            } else {
                preNo0Len++;
            }
        }
        result += preNo0Len / 2;
        return result >= n;
    }

    public static void main(String[] args) {
        System.out.println(canPlaceFlowers(new int[]{0, 0, 0, 0, 1, 0, 0, 0, 0}, 2));
    }
}
