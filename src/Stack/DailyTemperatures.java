package Stack;

import java.util.Stack;

public class DailyTemperatures {

    /**
     * 739、每日温度
     * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。
     * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
     * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
     * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        if(temperatures==null||temperatures.length<=0)
            return new int[0];
        //存储元素的position
        Stack<Integer> stack=new Stack<>();
        int[] out=new int[temperatures.length];
        for(int i=temperatures.length-1;i>=0;i--){
            while(!stack.isEmpty()&&temperatures[i]>=temperatures[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                out[i]=0;
            }else{
                out[i]=stack.peek()-i;
            }
            stack.push(i);
        }
        return out;
    }
}
