package BackTrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static void main(String[] args) {
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();
        System.out.println(generateParenthesis.generateParenthesis(3));
    }
    List<String> result;
    static StringBuilder sb = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        result = new ArrayList<>();
        if (n <= 0)
            return result;
        generate(n, n);
        return result;
    }

    private void generate(int left, int right) {
        if (left > right)
            return;
        if (left == 0) {
            int temp = right;
            while (temp > 0) {
                sb.append(')');
                temp--;
            }
            result.add(sb.toString());
            temp = right;
            sb.delete(sb.length() - right, sb.length());
            return;
        }
        sb.append('(');
        generate(left - 1, right);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(')');
        generate(left, right - 1);
        sb.deleteCharAt(sb.length() - 1);
    }
}
