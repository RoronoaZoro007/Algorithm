package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 350 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * 说明：
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 */
public class Intersect {

    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null||nums2==null||nums1.length<=0||nums2.length<=0)
            return new int[0];
        HashMap<Integer,Integer> cntMap=new HashMap<>();
        List<Integer> result=new ArrayList<>();
        for(int i=0;i<nums1.length;i++){
            cntMap.put(nums1[i],cntMap.getOrDefault(nums1[i],0)+1);
        }
        for(int i=0;i<nums2.length;i++){
            if(cntMap.getOrDefault(nums2[i],0)>0){
                result.add(nums2[i]);
                cntMap.put(nums2[i],cntMap.getOrDefault(nums2[i],0)-1);
            }
        }
        int[] temp=new int[result.size()];
        for(int i=0;i<result.size();i++){
            temp[i]=result.get(i);
        }
        return temp;
    }
}
