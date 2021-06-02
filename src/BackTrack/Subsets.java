package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * 输入：nums = [0]
 * 输出：[[],[0]]
 */
public class Subsets {


    /**
     * 经典回溯算法，排序先，然后通过一个boolean数组来标识是否被访问了，当一个元素和上一元素相同，但是上一元素没有被访问，这就是重复的一个组合
     */
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        if (nums == null || nums.length <= 0)
            return result;
        Arrays.sort(nums);
        boolean[] isVisited = new boolean[nums.length];
        result.add(new LinkedList<>());
        backTrack(nums, 0, new LinkedList<>(), isVisited);
        return result;
    }

    private void backTrack(int[] nums, int startPos, LinkedList<Integer> temp, boolean[] isVisited) {
        if (startPos == nums.length)
            return;
        for (int i = startPos; i < nums.length; i++) {
            //如果当前元素和上一个元素相同，且上一个元素没有被访问过，那么是重复的组合，排除掉
            if (i > 0 && nums[i] == nums[i - 1] && !isVisited[i - 1])
                continue;
            temp.add(nums[i]);
            isVisited[i] = true;
            result.add(new LinkedList<>(temp));
            backTrack(nums, i + 1, temp, isVisited);
            isVisited[i] = false;
            temp.removeLast();
        }
    }

    public static void main(String[] args) {
        Subsets subsets=new Subsets();
        System.out.println(subsets.subsets(new int[]{2,2,2,3}));
    }
}
