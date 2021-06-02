package Others;

import java.util.Arrays;

public class IsStraight {

    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int everyNum=0;
        int temp=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                everyNum++;
            }else{
                if(i>=1&&nums[i-1]!=0){
                    if(nums[i]==nums[i-1]){
                        return false;
                    }else{
                        temp+=nums[i]-nums[i-1]-1;
                    }
                }
            }
        }
        return everyNum>=temp;
    }

    public static void main(String[] args) {
        IsStraight isStraight=new IsStraight();
        System.out.println(isStraight.isStraight(new int[]{0,0,2,2,5}));
    }
}
