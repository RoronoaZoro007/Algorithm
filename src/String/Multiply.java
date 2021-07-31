package String;


public class Multiply {

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() <= 0 || num2.length() <= 0)
            return "";
        int len1 = num1.length();
        int len2 = num2.length();
        char[] chars1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] chars2 = new StringBuilder(num2).reverse().toString().toCharArray();
        int[] nums = new int[len1 + len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                int result = (chars1[i] - '0') * (chars2[j] - '0') + nums[i + j];
                nums[i + j] = result % 10;
                nums[i + j + 1] += result / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i;
        for (i = len1 + len2 - 1; i >= 0; i--) {
            if (nums[i] != 0) {
                break;
            }
        }
        while (i >= 0) {
            sb.append(nums[i]);
            i--;
        }
        //可能有一个数是0，因此判断一下
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        Multiply multiply = new Multiply();
        System.out.println(multiply.multiply("123", "456"));
    }
}
