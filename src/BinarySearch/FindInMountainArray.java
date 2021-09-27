package BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 1095 山脉数组查找目标值
 * 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 值。
 * 如果不存在这样的下标 index，就请返回 -1。
 * 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：
 * 首先，A.length >= 3
 * 其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 * 你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：
 * MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
 * MountainArray.length() - 会返回该数组的长度
 */
public class FindInMountainArray {

    interface MountainArray {
        public int get(int index);

        public int length();
    }

    //tip:首先二分查找到山脉数组的峰值点pos，然后对peekPos前面的递增数组和peekPos后面的递减数组，分别二分搜索即可
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int len = mountainArr.length();
        if (len <= 0)
            return -1;

        int start = 0;
        int end = len - 1;
        //找到peekPos，即峰值位置
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (mountainArr.get(mid + 1) > mountainArr.get(mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        int peekPos = start;

        //找前半个递增数组，找到了直接返回，否则找后面的递减数组
        start = 0;
        end = peekPos;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) {
                return mid;
            } else if (midVal > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        //找递减数组
        start = peekPos + 1;
        end = len - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midVal = mountainArr.get(mid);
            if (midVal == target) {
                return mid;
            } else if (midVal > target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        System.out.println(findInMountainArray(3, Stream.of(0,1,2,4,2,1).collect(Collectors.toList())));
    }
}
