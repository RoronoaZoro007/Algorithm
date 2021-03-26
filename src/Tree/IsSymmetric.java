package Tree;

public class IsSymmetric {

    /**
     * 判断一棵树是不是二叉树
     *
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return false;
        return judge(root.left, root.right);
    }

    public boolean judge(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val)
            return false;
        return judge(left.left, right.right)&&judge(left.right, right.left);
    }
}
