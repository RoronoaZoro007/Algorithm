package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class GetPermutation {

    /**
     * 60 排列序列
     * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
     * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * 给定 n 和 k，返回第 k 个排列。
     * 示例 1：
     * 输入：n = 3, k = 3
     * 输出："213"
     * 示例 2：
     * 输入：n = 4, k = 9
     * 输出："2314"
     * 示例 3：
     * 输入：n = 3, k = 1
     * 输出："123"
     * 提示：
     * 1 <= n <= 9
     * 1 <= k <= n!
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        if(n<=0||k<=0)
            return "";
        int[] nums=new int[n];
        for (int i = 0; i < n; i++) {
            nums[i]=i+1;
        }
        List<String> tempList=new ArrayList<>();
        getResult(nums,tempList,0,k);
        return tempList.get(k);
    }

    private void getResult(int[] nums, List<String> tempList,int pos,int k){
        if(pos== nums.length){
            StringBuilder sb=new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                sb.append(nums[i]);
            }
            tempList.add(sb.toString());
            return;
        }
        for (int i = pos; i < nums.length; i++) {
            swap(nums,pos,i);
            getResult(nums,tempList,pos+1,k);
            swap(nums,pos,i);
        }
    }

    private void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }

    public static void main(String[] args) {
        GetPermutation getPermutation=new GetPermutation();
        System.out.println(getPermutation.getPermutation(3,6));
    }
}
