package Matrix;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 378、有序矩阵中第k小元素
 * 给你一个 n x n 矩阵 matrix ，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是 排序后 的第 k 小元素，而不是第 k 个 不同 的元素。
 * 示例 1：
 * 输入：matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
 * 输出：13
 * 解释：矩阵中的元素为 [1,5,9,10,11,12,13,13,15]，第 8 小元素是 13
 * 示例 2：
 * 输入：matrix = [[-5]], k = 1
 * 输出：-5
 */
public class KthSmallest {

    public int kthSmallest(int[][] matrix, int k) {
        return 0;
    }

    public int kthSmallest_1(int[][] matrix, int k) {
        if(matrix==null||matrix.length<=0||matrix[0].length<=0||k<=0||k>matrix.length*matrix[0].length)
            return Integer.MIN_VALUE;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < matrix.length; i++) {
            priorityQueue.offer(new int[]{matrix[i][0], i, 0});
        }
        for(int i=0;i<k-1;i++){
            int[] temp=priorityQueue.poll();
            if(temp[2]!=matrix[0].length-1){
                priorityQueue.offer(new int[]{matrix[temp[1]][temp[2]+1],temp[1],temp[2]+1});
            }
        }
        return priorityQueue.poll()[0];
    }

    public static void main(String[] args) {
        KthSmallest kthSmallest=new KthSmallest();
        System.out.println(kthSmallest.kthSmallest_2(new int[][]{{1,2},{1,3}},3));
    }

    public int kthSmallest_2(int[][] matrix, int k){
        if(matrix==null||matrix.length<=0||matrix[0].length<=0||k<=0||k>matrix.length*matrix[0].length)
            return Integer.MIN_VALUE;
        int row=matrix.length;
        int col=matrix[0].length;
        int minVal=matrix[0][0];
        int maxVal=matrix[row-1][col-1];
        while (minVal<maxVal){
            int midVal=minVal+(maxVal-minVal)/2;
            if(getMinOrEqualToValCnt(matrix,midVal)>=k){
                maxVal=midVal;
            }else{
                minVal=midVal+1;
            }
        }
        return minVal;
    }

    private int getMinOrEqualToValCnt(int[][] matrix,int val){
        int i=matrix.length-1;
        int j=0;
        int cnt=0;
        while(i>=0&&j<matrix[0].length){
            if(matrix[i][j]<=val){
                cnt+=i+1;
                j++;
            }else{
                i--;
            }
        }
        return cnt;
    }
}
