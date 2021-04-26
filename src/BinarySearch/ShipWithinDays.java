package BinarySearch;

import java.util.Arrays;

/**
 * 1011.传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 */
public class ShipWithinDays {

    /**
     * tip:二分查找，查找到
     *
     * @param weights
     * @param D
     * @return
     */
    public int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while (left < right) {
            int mid = (left + right) / 2;
            int currWeight = 0;
            int curDays = 1;
            for (int weight : weights) {
                if (currWeight + weight > mid) {
                    currWeight = 0;
                    curDays++;
                }
                currWeight += weight;
            }
            if (curDays <= D) {
                //当前需要的天数小了，说明还有压榨的空间，可以一天放置更少的量
                //存在等于的情况，因此可能mid确实就是最小的情况了，所以取等于
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
