package BinarySearch;

/**
 * 4、寻找两个正序数组的中位数
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * <p>
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */
public class FindMedianSortedArrays {

    /**
     * tip
     * A: .....L1 R1 .......
     * B: .....L2 R2 .......
     * 其中A中L1前的元素数量+B中L2前的元素数量 =总长度的一半
     * 要满足 L1<R1 && L1<R2 L2<R1 && L2 < R2
     * 这样才为median
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return nums1.length > nums2.length ? findMedian(nums2, nums1) : findMedian(nums1, nums2);
    }

    //nums1为长度小的数组
    private double findMedian(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int allLen = len1 + len2;
        if (len1 == 0) {
            if (len2 == 0) {
                return 0.0;
            }
            int mid = len2 / 2;
            if (len2 % 2 == 0) {
                return nums2[mid - 1] + (nums2[mid] - nums2[mid-1]) / 2.0;
            } else {
                return nums2[mid];
            }
        }
        int left = 0;
        int right = nums1.length;
        int provideA;
        int provideB;
        double result = 0.0;
        while (left <= right) {
            //A数组提供的元素的个数
            provideA = left + (right - left) / 2;
            //B数组提供的元素的个数
            provideB = (allLen + 1) / 2 - provideA;
            int L1 = (provideA == 0 ? Integer.MIN_VALUE : nums1[provideA - 1]);
            int R1 = (provideA == len1 ? Integer.MAX_VALUE : nums1[provideA]);
            int L2 = (provideB == 0) ? Integer.MIN_VALUE : nums2[provideB - 1];
            int R2 = (provideB == len2 ? Integer.MAX_VALUE : nums2[provideB]);
            if (L1 > R2) {
                //A提供的大了，要减少A个数
                right = provideA - 1;
            } else if (L2 > R1) {
                //B提供的大了，要增加A个数
                left = provideA + 1;
            } else {
                if (allLen % 2 == 0) {
                    //这时候刚好提供一半的元素的个数，但是是偶数，还要多额外一个元素
                    //例如：1，3，5，7和2，4，6，8
                    //找到了3和4，提供了4个元素，找到这4个已经提供的元素中的最大值，
                    //还额外需要剩下的一半中最小的一个元素，相加/2才是最终结果
                    result = (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                } else {
                    result = Math.max(L1, L2);
                }
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        System.out.println(findMedianSortedArrays.findMedianSortedArrays(new int[]{1, 2, 3, 4}, new int[]{3, 4}));
    }
}
