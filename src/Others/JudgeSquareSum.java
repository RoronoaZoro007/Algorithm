package Others;

public class JudgeSquareSum {

    public static boolean judgeSquareSum(int c) {
        if (c < 0)
            return false;
        int mid = (int) Math.sqrt(c);
        for (int i = 0; i <= mid; i++) {
            int temp = c - (int) Math.pow(i, 2);
            if (Math.pow((int) Math.sqrt(temp), 2) == temp)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(2));
    }
}
