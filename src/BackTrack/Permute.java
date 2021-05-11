package BackTrack;

import java.util.*;

public class Permute {

    List<List<Integer>> result;

    //46. 没有重复数字的全排列
    //给定一个 没有重复 数字的序列，返回其所有可能的全排列。
    //示例:
    //输入: [1,2,3]
    //输出:
    //[
    //  [1,2,3],
    //  [1,3,2],
    //  [2,1,3],
    //  [2,3,1],
    //  [3,1,2],
    //  [3,2,1]
    //]
    public List<List<Integer>> permute(int[] nums) {
        result = new LinkedList<>();
        getResult(nums,new LinkedList<>(),new HashSet<>());
        return result;
    }

    private void getResult(int[] nums, LinkedList<Integer> list, HashSet<Integer> hashSet) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        }
        for (int num : nums) {
            if (!hashSet.contains(num)) {
                list.add(num);
                hashSet.add(num);
                getResult(nums, list, hashSet);
                list.removeLast();
                hashSet.remove(num);
            }
        }
    }



    public List<List<Integer>> permute_1(int[] nums) {
        result = new LinkedList<>();
        List<Integer> temp=new ArrayList<>();
        for(int num:nums){
            temp.add(num);
        }
        getResult_1(temp,0);
        return result;
    }

    private void getResult_1(List<Integer> nums,int start){
        if(start==nums.size()){
            result.add(new ArrayList<>(nums));
            return;
        }
        for (int i = start; i <nums.size() ; i++) {
            swap(nums,start,i);
            getResult_1(nums,start+1);
            swap(nums,start,i);
        }
    }

    private void swap(List<Integer> nums,int left,int right){
        int temp=nums.get(left);
        nums.set(left,nums.get(right));
        nums.set(right,temp);
    }


    public static void main(String[] args) {
        Permute permute=new Permute();
        System.out.println(permute.permuteUnique(new int[]{1,1,2,2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new LinkedList<>();
        List<Integer> temp=new ArrayList<>();
//        Arrays.sort(nums);
        for(int num:nums){
            temp.add(num);
        }
        getUniqueResult(temp,0);
        return result;
    }

    private void getUniqueResult(List<Integer> nums,int start){
        if(start==nums.size()){
            result.add(new ArrayList<>(nums));
            return;
        }
        for (int i = start; i <nums.size() ; i++) {
            if(canSwap(nums,start,i)){
                swap(nums,start,i);
                getUniqueResult(nums,start+1);
                swap(nums,start,i);
            }
        }
    }

    //如果在swap交换的两个start和i之间，有元素的值和i相同，说明之前已经交换过一次了，就跳过这个交换！！！
    private boolean canSwap(List<Integer> nums,int begin,int end) {
        for (int i = begin;i < end;i++) {
            if (nums.get(i) == nums.get(end)) {
                return false;
            }
        }
        return true;
    }


    boolean[] vis;
    public List<List<Integer>> permuteUnique_1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> perm = new ArrayList<Integer>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, 0, perm);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, int idx, List<Integer> perm) {
        if (idx == nums.length) {
            ans.add(new ArrayList<Integer>(perm));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            //如果这个元素被用过了，跳过
            if (vis[i]) {
                continue;
            }
            //nums[i] == nums[i - 1]表示当前这个元素和之前的元素是重复的
            //!vis[i - 1]表示在其position前面的元素重复的情况下，且其前相同的元素没有被用过，这个要被过滤
            //例如：存在1和1'两个元素，可以1，1'排列，那就不可以1'，1这种排列了，因为这种是重复的情况，需要剔除！！！
            if((i > 0 && nums[i] == nums[i - 1] && !vis[i - 1])){
                continue;
            }
            perm.add(nums[i]);
            vis[i] = true;
            backtrack(nums, ans, idx + 1, perm);
            vis[i] = false;
            perm.remove(idx);
        }
    }

}
