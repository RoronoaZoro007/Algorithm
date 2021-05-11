package BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> result;

    /**
     * 39 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的数字可以无限制重复被选取。
     * 说明：
     * 所有数字（包括 target）都是正整数。
     * 解集不能包含重复的组合。 
     * 示例 1：
     * 输入：candidates = [2,3,6,7], target = 7,
     * 所求解集为：
     * [
     *   [7],
     *   [2,2,3]
     * ]
     * 示例 2：
     * 输入：candidates = [2,3,5], target = 8,
     * 所求解集为：
     * [
     *   [2,2,2,2],
     *   [2,3,3],
     *   [3,5]
     * ]
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result=new ArrayList<>();
        if(candidates==null||candidates.length<=0||target<=0)
            return result;
        getResult(candidates,target,0,0,new LinkedList<Integer>());
        return result;
    }

    public void getResult(int[] candidates,int target,int nowSum,int start,LinkedList<Integer> list){
        if(nowSum==target){
            result.add(new LinkedList<Integer>(list));
            return;
        }
        if(nowSum>target)
            return;
        for(int i=start;i<candidates.length;i++){
            list.add(candidates[i]);
            getResult(candidates,target,nowSum+candidates[i],i,list);
            list.removeLast();
        }
    }


    /**
     * 40. 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * candidates 中的每个数字在每个组合中只能使用一次。
     * 说明：
     * 所有数字（包括目标数）都是正整数。
     * 解集不能包含重复的组合。 
     * 示例 1:
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 所求解集为:
     * [
     *   [1, 7],
     *   [1, 2, 5],
     *   [2, 6],
     *   [1, 1, 6]
     * ]
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        result=new ArrayList<>();
        if(candidates==null||candidates.length<=0||target<=0)
            return result;
        Arrays.sort(candidates);
        boolean[] isUsed=new boolean[candidates.length];
        getResult_2(candidates,isUsed,target,0,0,new LinkedList<Integer>());
        return result;
    }

    public void getResult_2(int[] candidates,boolean[] isUsed,int target,int nowSum,int start,LinkedList<Integer> list){
        if(nowSum==target){
            result.add(new LinkedList<Integer>(list));
            return;
        }
        if(nowSum>target)
            return;
        for(int i=start;i<candidates.length;i++){
            if(i>0&&candidates[i]==candidates[i-1]&&isUsed[i-1]==false)
                continue;
            list.add(candidates[i]);
            isUsed[i]=true;
            getResult_2(candidates,isUsed,target,nowSum+candidates[i],i+1,list);
            list.removeLast();
            isUsed[i]=false;
        }
    }

    /**
     * 216 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
     * 说明：
     * 所有数字都是正整数。
     * 解集不能包含重复的组合。 
     * 示例 1:
     * 输入: k = 3, n = 7
     * 输出: [[1,2,4]]
     * 示例 2:
     * 输入: k = 3, n = 9
     * 输出: [[1,2,6], [1,3,5], [2,3,4]]
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        result=new ArrayList<>();
        if(k<=0||n<=0)
            return result;
        getResult_3(n,0,1,k,0,new LinkedList<Integer>());
        return result;
    }

    public void getResult_3(int target,int nowSum,int start,int limit,int cnt,LinkedList<Integer> list){
        if(cnt>limit)
            return;
        if(cnt==limit){
            if(nowSum==target)
                result.add(new LinkedList<Integer>(list));
            return;
        }
        if(nowSum>target)
            return;
        for(int i=start;i<=9;i++){
            list.add(i);
            getResult_3(target,nowSum+i,i+1,limit,cnt+1,list);
            list.removeLast();
        }
    }


    /**
     * 给你一个由不同整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
     * 题目数据保证答案符合 32 位整数范围。
     * 示例 1：
     * 输入：nums = [1,2,3], target = 4
     * 输出：7
     * 解释：
     * 所有可能的组合为：
     * (1, 1, 1, 1)
     * (1, 1, 2)
     * (1, 2, 1)
     * (1, 3)
     * (2, 1, 1)
     * (2, 2)
     * (3, 1)
     * 请注意，顺序不同的序列被视作不同的组合。
     * tip:回溯超时
     * tip2:由于此时数组中的数值可以随意取，因此变量只有target，为一维的dp
     * @param nums
     * @param target
     * @return
     */
    int resultCnt=0;
    public int combinationSum4(int[] nums, int target) {
        if(nums==null||nums.length<=0)
            return 0;
        //目标值为target的最大组合数
        int[] dp=new int[target+1];
        dp[0]=1;
        for (int j = 1; j <=target; j++) {
            for (int i = 0; i <nums.length; i++) {
                if(j>=nums[i])
                    dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSum combinationSum=new CombinationSum();
        System.out.println(combinationSum.combinationSum4(new int[]{1,2,3},4));
    }
}
