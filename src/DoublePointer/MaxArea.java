package DoublePointer;

/**
 * 11、盛水最多的容器
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 * 示例 3：
 * 输入：height = [4,3,2,1,4]
 * 输出：16
 * 示例 4：
 * 输入：height = [1,2,1]
 * 输出：2
 */
public class MaxArea {

    /**
     * tip：双指针，分别指向start和end，每次移动start和end指向的元素中的最小的那个指针
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        if(height==null||height.length<=1)
            return 0;
        int start=0;
        int end=height.length-1;
        int maxArea=0;
        while (start<end){
            maxArea=Math.max(maxArea,(end-start)*Math.min(height[start],height[end]));
            if(height[start]<height[end]){
                start++;
            }else{
                end--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        MaxArea maxArea=new MaxArea();
        System.out.println(maxArea.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
