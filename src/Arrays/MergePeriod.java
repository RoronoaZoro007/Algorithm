package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergePeriod {

    public static void main(String[] args) {
        MergePeriod mergePeriod=new MergePeriod();
        int[][] arr=new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println(mergePeriod.merge(arr));
    }

    public int[][] merge(int[][] intervals) {
        List<int[]> result=new ArrayList<>();
        if(intervals==null||intervals.length<=0||intervals[0].length<=0)
            return new int[0][0];
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o1[0]-o2[0];
                }else{
                    return o2[1]-o1[1];
                }
            }
        });
        result.add(new int[]{intervals[0][0],intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) {
            int[] temp=result.get(result.size()-1);
            if(intervals[i][0]>=temp[0]&&intervals[i][1]<=temp[1]){
                //在前一个区间里面，直接返回
            }else if(intervals[i][0]>=temp[0]&&intervals[i][0]<=temp[1]&&intervals[i][1]>temp[1]){
                result.set(result.size()-1,new int[]{temp[0],intervals[i][1]});
            }else if(intervals[i][0]>temp[1]){
                result.add(new int[]{intervals[i][0],intervals[i][1]});
            }
        }
        return result.toArray(new int[0][]);
    }
}
