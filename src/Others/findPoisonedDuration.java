package Others;

public class findPoisonedDuration {
    public static void main(String[] args) {
        System.out.println(findPoisonedDuration1(new int[]{1,4},2));
    }
    public static int findPoisonedDuration1(int[] timeSeries, int duration) {
        if(timeSeries==null||timeSeries.length==0||duration<=0)
            return 0;
        int result=0;
        for (int i = 0; i < timeSeries.length-1; i++) {
            int gapLen=timeSeries[i+1]-timeSeries[i];
            result+=(gapLen>duration?duration:gapLen);
        }
        return result+duration;
    }
}
