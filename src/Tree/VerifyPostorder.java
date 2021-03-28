package Tree;

public class VerifyPostorder {

    public static void main(String[] args) {
        VerifyPostorder order = new VerifyPostorder();
        System.out.println(order.verifyPostorder(new int[]{5, 4, 3, 2, 1}));
    }

    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null)
            return true;
        return verify(postorder, 0, postorder.length - 1);
    }

    private boolean verify(int[] postorder, int start, int end) {
        if (start >= end)
            return true;
        int midPos = start;
        while (midPos < end) {
            if (postorder[midPos] > postorder[end])
                break;
            midPos++;
        }
        if (midPos == end)
            return verify(postorder, start, end - 1);
        int tempRight = midPos;
        while (tempRight < end) {
            if (postorder[tempRight] < postorder[end])
                break;
            tempRight++;
        }
        if (tempRight != end)
            return false;
        return verify(postorder, start, midPos - 1) && verify(postorder, midPos, end - 1);
    }
}
