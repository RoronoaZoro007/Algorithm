package Tree;

public class MaxPathSum {

    int temp = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getMaxPath(root);
        return temp;
    }

    public int getMaxPath(TreeNode root) {
        if (root == null)
            return 0;
        int left = Math.max(0, getMaxPath(root.left));
        int right = Math.max(0, getMaxPath(root.right));
        temp = Math.max(temp, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}
