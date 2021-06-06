package Arrays;

public class MaximumSwap {


    public int maximumSwap(int num) {
        StringBuilder numString = new StringBuilder(String.valueOf(num));
        char[] array = String.valueOf(num).toCharArray();
        int len = array.length;
        int[] maxPos = new int[len];
        maxPos[len - 1] = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            if (array[i] <= array[maxPos[i + 1]]) {
                maxPos[i] = maxPos[i + 1];
            } else {
                maxPos[i] = i;
            }
        }
        for (int i = 0; i < len; i++) {
            if (maxPos[i] != i && array[maxPos[i]] != array[i]) {
                char c = numString.charAt(i);
                numString.setCharAt(i, numString.charAt(maxPos[i]));
                numString.setCharAt(maxPos[i], c);
                return Integer.parseInt(numString.toString());
            }
        }
        return num;
    }

    public static void main(String[] args) {
        MaximumSwap maximumSwap = new MaximumSwap();
        System.out.println(maximumSwap.maximumSwap(1993));
    }
}
