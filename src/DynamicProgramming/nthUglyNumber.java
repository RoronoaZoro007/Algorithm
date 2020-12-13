package DynamicProgramming;

public class nthUglyNumber {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    public static int nthUglyNumber(int n) {
        int[] nums=new int[n];
        int pos2=0;
        int pos3=0;
        int pos5=0;
        nums[0]=1;
        int currPos=0;
        //三指针，创建一个只有nums[0]=1的空的初始数组，数2，3，5的指针都指向这个pos
        //让当前三个指针指向的pos对应的nums数组乘上其对应的因子，取其最小值加入nums数组的尾部
        //乘积值为最小值的指针对应的位置向前移动一位（ps：所有的3种都进行判断，存在相等的时，同时移动，可以避免数组的重复值出现）
        while(currPos<n-1){
            int num2=nums[pos2]*2;
            int num3=nums[pos3]*3;
            int num5=nums[pos5]*5;
            int min=Math.min(num2,Math.min(num3,num5));
            currPos++;
            nums[currPos]=min;
            if(num2==min)
                pos2++;
            if(num3==min)
                pos3++;
            if(num5==min)
                pos5++;
        }
        return nums[n-1];
    }
}
