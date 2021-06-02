package Arrays;

import java.util.Arrays;

public class FindDuplicate {

    /**
     * 287.寻找重复的数
     * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。
     * 假设 nums 只有 一个重复的整数 ，找出 这个重复的数 。
     * 你设计的解决方案必须不修改数组 nums 且只用常量级 O(1) 的额外空间。
     * 示例 1：
     * 输入：nums = [1,3,4,2,2]
     * 输出：2
     * 示例 2：
     * 输入：nums = [3,1,3,4,2]
     * 输出：3
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        /**
         * 由于需要O（1）的空间复杂度，因此只能原地交换
         * 按照每个元素的值将其放置到对应的位置上，比如说值为a，那么就应该放在pos=a-1的位置上
         * 也就是1放在pos——0上，2放在pos——1上，依此类推
         * 遍历nums的所有元素，当当前位置上放置的不是应有的元素时，就将其和其应放置位置上的元素进行交换
         * 如果交换位置的元素已经是正确的值了，说明这个元素就是重复的元素，退出返回即可
         */
        int result=0;
        for(int i=0;i<nums.length;i++){
            //当前数为nums[i]
            //nums[i] ->pos: nums[i]-1
            if(nums[i]!=i+1){
                if(nums[nums[i]-1]==nums[i]){
                    result=nums[i];
                    break;
                }else{
                    swap(nums,i,nums[i]-1);
                    i--;
                }
            }
        }
        return result;
    }

    private void swap(int[] nums,int pos1,int pos2){
        int temp=nums[pos1];
        nums[pos1]=nums[pos2];
        nums[pos2]=temp;
    }

    public static void main(String[] args) {
        FindDuplicate findDuplicate=new FindDuplicate();
        System.out.println(findDuplicate.findDuplicate(new int[]{1,3,2,4,2}));
    }
}
