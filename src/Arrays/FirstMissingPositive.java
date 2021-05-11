package Arrays;

public class FirstMissingPositive {

    public static void main(String[] args) {
        FirstMissingPositive firstMissingPositive=new FirstMissingPositive();
        System.out.println(firstMissingPositive.firstMissingPositive(new int[]{3,4,-1,1,2}));
    }

    public int firstMissingPositive(int[] nums) {
        //置换
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0&&nums[i]<=nums.length){
                //
                if(nums[nums[i]-1]!=nums[i]){
                    swap(nums,nums[i]-1,i);
                    i--;
                }
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1)
                return i+1;
        }
        return nums.length+1;
    }

    private void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}
